package tn.esprit.tp_autoloc.service;

import tn.esprit.tp_autoloc.web.dto.ContratDTO;

import java.util.List;

public interface IContratService {
    ContratDTO create(ContratDTO dto);
    ContratDTO findById(Long id);
    List<ContratDTO> findAll();
    ContratDTO update(Long id, ContratDTO dto);
    void deleteById(Long id);
}