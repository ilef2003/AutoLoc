package tn.esprit.tp_autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tp_autoloc.domain.enums.RoleEmployee;
import java.util.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private RoleEmployee role;

    @ManyToOne
    @JoinColumn(name= "id_agence")
    private Agence agence;
}