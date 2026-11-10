package tn.esprit.tp_autoloc.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO {
    private Long id;

    @NotBlank(message = "Le libellé est obligatoire")
    private String libelle;
}