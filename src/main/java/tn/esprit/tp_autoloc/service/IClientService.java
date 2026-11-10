package tn.esprit.tp_autoloc.service;

import tn.esprit.tp_autoloc.web.dto.ClientDTO;

import java.util.List;

public interface IClientService {
    ClientDTO create(ClientDTO dto);
    ClientDTO findById(Long id);
    List<ClientDTO> findAll();
    ClientDTO update(Long id, ClientDTO dto);
    void deleteById(Long id);
}