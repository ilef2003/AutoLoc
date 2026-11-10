package tn.esprit.tp_autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    public Long getIdContrat() {
        return idContrat;
    }

    public LocalDate getDateSignature() {
        return dateSignature;
    }

    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    public Boolean getValide() {
        return valide;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private Boolean valide;

    @OneToOne(mappedBy = "contrat")
    private Reservation reservation;

    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paiement> paiements = new ArrayList<>();
}