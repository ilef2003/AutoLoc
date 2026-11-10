package tn.esprit.tp_autoloc.service.strategy;

import tn.esprit.tp_autoloc.domain.Reservation;
import tn.esprit.tp_autoloc.domain.Vehicule;

import java.math.BigDecimal;

public interface ITarificationStrategy {
    BigDecimal calculerTarif(Vehicule vehicule, Reservation reservation);
    String getCode();
}