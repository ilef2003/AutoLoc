package tn.esprit.tp_autoloc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tp_autoloc.domain.Agence;
import tn.esprit.tp_autoloc.domain.Employee;
import tn.esprit.tp_autoloc.exception.ResourceNotFoundException;
import tn.esprit.tp_autoloc.repository.IAgenceRepository;
import tn.esprit.tp_autoloc.repository.IEmployeeRepository;
import tn.esprit.tp_autoloc.service.IEmployeeService;
import tn.esprit.tp_autoloc.web.dto.EmployeeDTO;
import tn.esprit.tp_autoloc.web.mapper.EmployeeMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;
    private final IAgenceRepository agenceRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("Un nouvel employé ne doit pas avoir d'identifiant");
        }
        Employee employee = employeeMapper.toEntity(dto);
        if (dto.getAgenceId() != null) {
            Agence agence = agenceRepository.findById(dto.getAgenceId())
                    .orElseThrow(() -> new ResourceNotFoundException("Agence", dto.getAgenceId()));
            employee.setAgence(agence);
        }
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employé", id));
        return employeeMapper.toDto(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDto).toList();
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee existant = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employé", id));

        existant.setNom(dto.getNom());
        existant.setPrenom(dto.getPrenom());
        existant.setRole(dto.getRole());

        if (dto.getAgenceId() != null) {
            Agence agence = agenceRepository.findById(dto.getAgenceId())
                    .orElseThrow(() -> new ResourceNotFoundException("Agence", dto.getAgenceId()));
            existant.setAgence(agence);
        }

        return employeeMapper.toDto(employeeRepository.save(existant));
    }

    @Override
    public void deleteById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employé", id);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public void affecterEmployeeAAgence(Long employeeId, Long agenceId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employé", employeeId));
        Agence agence = agenceRepository.findById(agenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", agenceId));

        employee.setAgence(agence);
        employeeRepository.save(employee);
    }

    @Override
    public void desaffecterEmployeeDeAgence(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employé", employeeId));

        if (employee.getAgence() == null) {
            throw new IllegalArgumentException("L'employé n'est rattaché à aucune agence");
        }

        employee.setAgence(null);
        employeeRepository.save(employee);
    }
}