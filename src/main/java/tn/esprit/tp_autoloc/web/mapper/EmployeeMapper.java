package tn.esprit.tp_autoloc.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tp_autoloc.domain.Employee;
import tn.esprit.tp_autoloc.web.dto.EmployeeDTO;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "id", source = "idEmployee")
    @Mapping(target = "agenceId", source = "agence.idAgence")
    EmployeeDTO toDto(Employee employee);

    @Mapping(target = "idEmployee", source = "id")
    @Mapping(target = "agence", ignore = true)
    Employee toEntity(EmployeeDTO dto);
}