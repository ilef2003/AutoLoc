package tn.esprit.tp_autoloc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_autoloc.service.IReservationService;
import tn.esprit.tp_autoloc.web.dto.ReservationRequestDTO;
import tn.esprit.tp_autoloc.web.dto.ReservationResponseDTO;
import tn.esprit.tp_autoloc.web.validator.ReservationRequestValidator;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService reservationService;
    private final ReservationRequestValidator reservationRequestValidator;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ReservationRequestDTO dto,
                                    BindingResult result) {
        reservationRequestValidator.validate(dto, result);

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getFieldErrors().stream()
                            .map(e -> e.getField() + " : " + e.getDefaultMessage())
                            .toList()
            );
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponseDTO>> findAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @Valid @RequestBody ReservationRequestDTO dto,
                                    BindingResult result) {
        reservationRequestValidator.validate(dto, result);

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getFieldErrors().stream()
                            .map(e -> e.getField() + " : " + e.getDefaultMessage())
                            .toList()
            );
        }

        return ResponseEntity.ok(reservationService.update(id, dto));
    }

    @PutMapping("/{id}/annuler")
    public ResponseEntity<Void> annuler(@PathVariable Long id) {
        reservationService.annulerReservation(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}