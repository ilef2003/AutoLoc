package tn.esprit.tp_autoloc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.tp_autoloc.domain.Agence;
import tn.esprit.tp_autoloc.domain.Client;
import tn.esprit.tp_autoloc.domain.Employee;
import tn.esprit.tp_autoloc.domain.Vehicule;

import tn.esprit.tp_autoloc.repository.IAgenceRepository;
import tn.esprit.tp_autoloc.repository.IClientRepository;
import tn.esprit.tp_autoloc.repository.IVehiculeRepository;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TpAutolocApplicationTests {

    @Autowired
    private IAgenceRepository agenceRepository;

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IVehiculeRepository vehiculeRepository;


    @Test
    void testAgenceRepository() {

        System.out.println("********** Test Agence Repository **********");

        // creation d'une instance
        Agence a = new Agence();

        a.setNom("agence1");
        a.setAdresse("Nabeul");

        // save()
        Agence agencesaved = agenceRepository.save(a);

        System.out.println("Agence cree : " + agencesaved);

        // récupérer l'id de l'agence
        Long id = agencesaved.getIdAgence();

        // findAll()
        List<Agence> agences = agenceRepository.findAll();

        System.out.println("Agence liste : " + agences);
        System.out.println("nombre d'agence : " + agences.size());

        assertNotNull(agences);
        assertFalse(
                agences.isEmpty(),
                "la base doit contenir au moins une agence"
        );

        // findById()
        Optional<Agence> agenceTrouvee =
                agenceRepository.findById(id);

        System.out.println("Agence trouvée : " + agenceTrouvee);

        assertTrue(agenceTrouvee.isPresent());

        // existsById()
        boolean existe =
                agenceRepository.existsById(id);

        System.out.println("Agence existe ? " + existe);

        assertTrue(existe);

        // count()
        long nombreAgences =
                agenceRepository.count();

        System.out.println(
                "Nombre total d'agences : "
                        + nombreAgences
        );

        assertTrue(nombreAgences > 0);

        // deleteById()
        agenceRepository.deleteById(id);

        System.out.println("Agence supprimée.");

        // vérifier qu'elle n'existe plus
        boolean existeApresSuppression =
                agenceRepository.existsById(id);

        System.out.println(
                "Agence existe après suppression ? "
                        + existeApresSuppression
        );

        assertFalse(existeApresSuppression);

        System.out.println(
                "********** Fin Test Agence **********"
        );
    }


    @Test
    void testClientRepository() {

        System.out.println("********** Test Client Repository **********");

        // Premier client
        Client c1 = new Client();

        c1.setNom("Yousfi");
        c1.setPrenom("Ilef");
        c1.setEmail("ilef@gmail.com");
        c1.setTelephone("20123456");
        c1.setNumPermis("P123456");
        c1.setDateInscription(LocalDate.now());

        // Deuxième client
        Client c2 = new Client();

        c2.setNom("Ben Ali");
        c2.setPrenom("Ahmed");
        c2.setEmail("ahmed@gmail.com");
        c2.setTelephone("22123456");
        c2.setNumPermis("P654321");
        c2.setDateInscription(LocalDate.now());

        // save()
        Client client1Saved =
                clientRepository.save(c1);

        Client client2Saved =
                clientRepository.save(c2);

        System.out.println("Client 1 : " + client1Saved);
        System.out.println("Client 2 : " + client2Saved);

        // récupérer l'id du premier client
        Long idClient1 =
                client1Saved.getIdClient();

        // findAll()
        List<Client> clients =
                clientRepository.findAll();

        System.out.println("Liste des clients : " + clients);
        System.out.println("Nombre de clients : " + clients.size());

        assertNotNull(clients);
        assertTrue(clients.size() >= 2);

        // findById()
        Optional<Client> clientTrouve =
                clientRepository.findById(idClient1);

        System.out.println("Client trouvé : " + clientTrouve);

        assertTrue(clientTrouve.isPresent());

        // existsById() avec un identifiant existant
        boolean existe =
                clientRepository.existsById(idClient1);

        System.out.println(
                "Le client 1 existe ? " + existe
        );

        assertTrue(existe);

        // existsById() avec un identifiant inexistant
        boolean inexistant =
                clientRepository.existsById(999999L);

        System.out.println(
                "Client avec ID 999999 existe ? "
                        + inexistant
        );

        assertFalse(inexistant);

        // count()
        long nombreClients =
                clientRepository.count();

        System.out.println(
                "Nombre total de clients : "
                        + nombreClients
        );

        assertTrue(nombreClients >= 2);

        System.out.println(
                "********** Fin Test Client **********"
        );
    }


    @Test
    void testVehiculeRepository() {

        System.out.println("********** Test Vehicule Repository **********");

        // création d'un véhicule
        Vehicule v = new Vehicule();

        v.setImmatriculation("123 TU 4567");
        v.setMarque("Renault");
        v.setModele("Clio");
        v.setTarifJournalier(
                new BigDecimal("80.00")
        );

        // save()
        Vehicule vehiculeSaved =
                vehiculeRepository.save(v);

        System.out.println(
                "Véhicule créé : " + vehiculeSaved
        );

        // récupérer l'id
        Long idVehicule =
                vehiculeSaved.getIdVehicule();

        // findAll()
        List<Vehicule> vehicules =
                vehiculeRepository.findAll();

        System.out.println(
                "Liste des véhicules : "
                        + vehicules
        );

        // count()
        long nombreVehicules =
                vehiculeRepository.count();

        System.out.println(
                "Nombre de véhicules : "
                        + nombreVehicules
        );

        assertTrue(nombreVehicules > 0);

        // modifier une propriété
        vehiculeSaved.setTarifJournalier(
                new BigDecimal("90.00")
        );

        // save() pour enregistrer la modification
        Vehicule vehiculeModifie =
                vehiculeRepository.save(vehiculeSaved);

        System.out.println(
                "Véhicule après modification : "
                        + vehiculeModifie
        );

        // supprimer
        vehiculeRepository.deleteById(idVehicule);

        System.out.println("Véhicule supprimé.");

        System.out.println(
                "********** Fin Test Vehicule **********"
        );
    }

    @Test
    void testAgenceService(){
        Agence a = new Agence();
        a.setNom("Agence 1 ");
        a.setVille("Nabeul");
        a.setAdresse("Nabeul");
        a.setTelephone("22123456");

        // Création des employés
        Employee e1 = new Employee();
        e1.setNom("ahmed");
        e1.setPrenom("ahmed");

        Employee e2 = new Employee();
        e2.setNom("ali");
        e2.setPrenom("ali");

        // Affectation de la liste d'employés à l'agence
        a.setEmployees(List.of(e1, e2));

        // Sauvegarde pour tester (si tu voulais juste créer l'objet sans sauvegarder, tu peux enlever cette ligne)
        Agence savedAgence = agenceRepository.save(a);
        System.out.println("Agence sauvegardée avec employés : " + savedAgence);
    }
}