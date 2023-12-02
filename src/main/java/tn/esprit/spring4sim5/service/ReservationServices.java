package tn.esprit.spring4sim5.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring4sim5.entity.*;
import tn.esprit.spring4sim5.repository.iBlocRepository;
import tn.esprit.spring4sim5.repository.iChambreRepository;
import tn.esprit.spring4sim5.repository.iEtudiantRepository;
import tn.esprit.spring4sim5.repository.iReservationRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j

public class ReservationServices implements iReservationServices{
   final iReservationRepository reservationRepository;
   final iChambreRepository chambreRepository;
   final iEtudiantRepository etudiantRepository;
   final iBlocRepository blocRepository;
    @Override
    public Reservation modifierReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public void deleteReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation getReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElseGet(null);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return (List<Reservation>)reservationRepository.findAll();
    }

    @Transactional
    @Override
    public Reservation ajouterReservation (Long idBloc, Long cin)  {



            Bloc bloc = blocRepository.findById(idBloc)
                    .orElseThrow(() -> new RuntimeException("Bloc non trouvé avec l'ID : " + idBloc));

            Etudiant etudiant = etudiantRepository.findEtudiantByCin(cin);
            if (etudiant == null) {
                throw new RuntimeException("Etudiant non trouvé avec le CIN : " + cin);
            }

            // Recherche de la chambre associée au bloc
            Chambre chambre = bloc.getChambres().stream().findFirst()
                    .orElseThrow(() -> new RuntimeException("Aucune chambre associée au bloc : " + idBloc));
        log.info("Service test");
            // Création de la réservation
            Reservation reservation = new Reservation();
            reservation.setNumReservation(chambre.getNumeroChambre() + "-"  + "-" + cin);
            reservation.setEstValide(true);

            // Déterminer la capacité maximale en fonction du type de chambre
        int capaciteMax = 0;
        if (TypeChambre.SIMPLE.equals(chambre.getTypeC())) {
            capaciteMax = 1;
        } else if (TypeChambre.DOUBLE.equals(chambre.getTypeC())) {
            capaciteMax = 2;
        } else if (TypeChambre.TRIPLE.equals(chambre.getTypeC())) {
            capaciteMax = 3;
        }
            // Vérifier si la capacité maximale de la chambre est atteinte
            long nombreReservations = chambre.getReservations().size();
            if (nombreReservations >= capaciteMax) {
                throw new IllegalStateException("La capacité maximale de la chambre est atteinte.");
            }

            // Gérer la relation ManyToMany
            Set<Etudiant> etudiants = new HashSet<>();
            etudiants.add(etudiant);
            reservation.setEtudiants(etudiants);

            // Ajouter la réservation à la chambre avant de la sauvegarder
            chambre.getReservations().add(reservation);

            // Sauvegarder la réservation et mettre à jour la chambre
            Reservation savedReservation = reservationRepository.save(reservation);
            blocRepository.save(bloc);

            return savedReservation;

    }

    @Override
    @Transactional
    public Reservation annulerReservation(Long cinEtudiant) {
        // Trouver l'étudiant et sa réservation
        Etudiant etudiant = etudiantRepository.findEtudiantByCin(cinEtudiant);

        // Supposition: chaque étudiant a au maximum une réservation valide
        Reservation reservation = etudiant.getReservations().stream()
                .filter(Reservation::isEstValide)
                .findFirst()
                .orElse(null);

        // Mettre à jour l'état de la réservation
        reservation.setEstValide(false);

        // Désaffecter l'étudiant
        reservation.getEtudiants().remove(etudiant);

        // Désaffecter la chambre associée et mettre à jour sa capacité
        Chambre chambreAssociee = chambreRepository.findByReservationsContains(reservation);
        if (chambreAssociee != null) {
            chambreAssociee.getReservations().remove(reservation);
            chambreRepository.save(chambreAssociee); // Sauvegarder les changements dans la chambre
        }

        // Sauvegarder les modifications
        return reservationRepository.save(reservation);
    }
}

