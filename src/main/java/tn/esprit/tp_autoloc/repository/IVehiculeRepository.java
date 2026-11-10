package tn.esprit.tp_autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_autoloc.domain.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule,Long> {
}
