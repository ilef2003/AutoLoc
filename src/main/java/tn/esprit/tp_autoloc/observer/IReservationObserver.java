package tn.esprit.tp_autoloc.observer;

import tn.esprit.tp_autoloc.domain.Reservation;

public interface IReservationObserver {
    void onReservationConfirmee(Reservation reservation);
    void onReservationAnnulee(Reservation reservation);
}