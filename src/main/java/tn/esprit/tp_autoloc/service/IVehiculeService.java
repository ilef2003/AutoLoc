package tn.esprit.tp_autoloc.service;

import tn.esprit.tp_autoloc.web.dto.VehiculeDTO;

import java.util.List;

public interface IVehiculeService {
    VehiculeDTO create(VehiculeDTO dto);
    VehiculeDTO findById(Long id);
    List<VehiculeDTO> findAll();
    VehiculeDTO update(Long id, VehiculeDTO dto);
    void deleteById(Long id);

    void affecterVehiculeAAgence(Long vehiculeId, Long agenceId);
    void desaffecterVehiculeDeAgence(Long vehiculeId);
}