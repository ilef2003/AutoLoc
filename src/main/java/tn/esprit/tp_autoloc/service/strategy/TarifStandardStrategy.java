package tn.esprit.tp_autoloc.service.strategy;

import org.springframework.stereotype.Component;
import tn.esprit.tp_autoloc.domain.Reservation;
import tn.esprit.tp_autoloc.domain.Vehicule;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

@Component
public class TarifStandardStrategy implements ITarificationStrategy {

    @Override
    public BigDecimal calculerTarif(Vehicule vehicule, Reservation reservation) {
        if (vehicule == null || vehicule.getTarifJournalier() == null
                || reservation.getDateDebut() == null || reservation.getDateFin() == null) {
            return BigDecimal.ZERO;
        }
        long jours = ChronoUnit.DAYS.between(reservation.getDateDebut(), reservation.getDateFin());
        return vehicule.getTarifJournalier().multiply(BigDecimal.valueOf(Math.max(jours, 0)));
    }

    @Override
    public String getCode() {
        return "STANDARD";
    }
}