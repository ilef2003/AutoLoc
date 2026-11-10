package tn.esprit.tp_autoloc.service;

import tn.esprit.tp_autoloc.web.dto.MaintenanceDTO;

import java.util.List;

public interface IMaintenanceService {
    MaintenanceDTO create(MaintenanceDTO dto);
    MaintenanceDTO findById(Long id);
    List<MaintenanceDTO> findAll();
    MaintenanceDTO update(Long id, MaintenanceDTO dto);
    void deleteById(Long id);
}