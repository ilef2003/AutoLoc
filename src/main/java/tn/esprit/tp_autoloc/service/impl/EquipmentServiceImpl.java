package tn.esprit.tp_autoloc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tp_autoloc.domain.Equipment;
import tn.esprit.tp_autoloc.exception.ResourceNotFoundException;
import tn.esprit.tp_autoloc.repository.IEquipmentRepository;
import tn.esprit.tp_autoloc.service.IEquipmentService;
import tn.esprit.tp_autoloc.web.dto.EquipmentDTO;
import tn.esprit.tp_autoloc.web.mapper.EquipmentMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EquipmentServiceImpl implements IEquipmentService {

    private final IEquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    @Override
    public EquipmentDTO create(EquipmentDTO dto) {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("Un nouvel équipement ne doit pas avoir d'identifiant");
        }
        Equipment saved = equipmentRepository.save(equipmentMapper.toEntity(dto));
        return equipmentMapper.toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public EquipmentDTO findById(Long id) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Équipement", id));
        return equipmentMapper.toDto(equipment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipmentDTO> findAll() {
        return equipmentRepository.findAll().stream().map(equipmentMapper::toDto).toList();
    }

    @Override
    public EquipmentDTO update(Long id, EquipmentDTO dto) {
        Equipment existant = equipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Équipement", id));

        existant.setLibelle(dto.getLibelle());
        return equipmentMapper.toDto(equipmentRepository.save(existant));
    }

    @Override
    public void deleteById(Long id) {
        if (!equipmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Équipement", id);
        }
        equipmentRepository.deleteById(id);
    }
}