package tn.esprit.tp_autoloc.service;

import tn.esprit.tp_autoloc.web.dto.PaiementDTO;

import java.util.List;

public interface IPaiementService {
    PaiementDTO findById(Long id);
    List<PaiementDTO> findAll();
}