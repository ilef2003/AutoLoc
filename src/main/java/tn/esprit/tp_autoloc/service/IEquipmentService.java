package tn.esprit.tp_autoloc.service;

import tn.esprit.tp_autoloc.web.dto.EquipmentDTO;

import java.util.List;

public interface IEquipmentService {
    EquipmentDTO create(EquipmentDTO dto);
    EquipmentDTO findById(Long id);
    List<EquipmentDTO> findAll();
    EquipmentDTO update(Long id, EquipmentDTO dto);
    void deleteById(Long id);
}