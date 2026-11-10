package tn.esprit.tp_autoloc.service;

import tn.esprit.tp_autoloc.web.dto.ReservationRequestDTO;
import tn.esprit.tp_autoloc.web.dto.ReservationResponseDTO;

import java.util.List;

public interface IReservationService {
    ReservationResponseDTO create(ReservationRequestDTO dto);
    ReservationResponseDTO findById(Long id);
    List<ReservationResponseDTO> findAll();
    ReservationResponseDTO update(Long id, ReservationRequestDTO dto);
    void deleteById(Long id);
    void annulerReservation(Long id);
}