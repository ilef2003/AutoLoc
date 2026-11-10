package tn.esprit.tp_autoloc.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tp_autoloc.domain.Equipment;
import tn.esprit.tp_autoloc.web.dto.EquipmentDTO;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    @Mapping(target = "id", source = "idEquipment")
    EquipmentDTO toDto(Equipment equipment);

    @Mapping(target = "idEquipment", source = "id")
    @Mapping(target = "vehicules", ignore = true)
    Equipment toEntity(EquipmentDTO dto);
}