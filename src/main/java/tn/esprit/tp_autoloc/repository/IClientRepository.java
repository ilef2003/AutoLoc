package tn.esprit.tp_autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_autoloc.domain.Client;

public interface IClientRepository extends JpaRepository<Client,Long> {
}
