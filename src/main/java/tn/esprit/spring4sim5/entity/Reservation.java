package tn.esprit.spring4sim5.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReservation;

    String numReservation;

    @Temporal(TemporalType.DATE)
    LocalDate debutAnneeUniv;

    @Temporal(TemporalType.DATE)
    LocalDate finAnneeUniv;

    boolean estValide;


    @ManyToMany
    Set<Etudiant> etudiants;
}
