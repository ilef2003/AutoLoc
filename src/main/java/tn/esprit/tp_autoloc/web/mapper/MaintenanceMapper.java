package tn.esprit.tp_autoloc.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tp_autoloc.domain.Maintenance;
import tn.esprit.tp_autoloc.web.dto.MaintenanceDTO;

@Mapper(componentModel = "spring")
public interface MaintenanceMapper {
    @Mapping(target = "id", source = "idMaintenance")
    @Mapping(target = "vehiculeId", source = "vehicule.idVehicule")
    MaintenanceDTO toDto(Maintenance maintenance);

    @Mapping(target = "idMaintenance", source = "id")
    @Mapping(target = "vehicule", ignore = true)
    Maintenance toEntity(MaintenanceDTO dto);
}