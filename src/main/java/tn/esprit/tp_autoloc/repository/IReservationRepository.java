package tn.esprit.tp_autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_autoloc.domain.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation,Long> {
}
