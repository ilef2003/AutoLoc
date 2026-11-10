package tn.esprit.tp_autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_autoloc.domain.Equipment;

public interface IEquipmentRepository extends JpaRepository<Equipment,Long> {
}
