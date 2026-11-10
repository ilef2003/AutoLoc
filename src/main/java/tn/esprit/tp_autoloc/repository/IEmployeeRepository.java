package tn.esprit.tp_autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_autoloc.domain.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
