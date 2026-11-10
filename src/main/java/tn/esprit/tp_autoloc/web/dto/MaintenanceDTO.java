package tn.esprit.tp_autoloc.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceDTO {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;

    @NotNull(message = "Le véhicule est obligatoire")
    private Long vehiculeId;
}