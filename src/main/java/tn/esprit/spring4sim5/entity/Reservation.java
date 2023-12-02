package tn.esprit.spring4sim5.entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // or other appropriate strategy

    private String id_reservation;


    String numReservation;

    Date anneUniversitaire;

    boolean estValide;


    @ManyToMany
    Set<Etudiant> etudiants;
}
