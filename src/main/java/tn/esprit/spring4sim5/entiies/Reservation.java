package tn.esprit.spring4sim5.entiies;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
public class Reservation implements Serializable
        {
            @Id
            @GeneratedValue(strategy = GenerationType.SEQUENCE)
            @Setter(AccessLevel.NONE)
            private Long idreservation;
            private Date anneuniversaire;
            private boolean estvalide;

            @ManyToMany(mappedBy="res", cascade = CascadeType.ALL)
            private Set<tn.esprit.spring4sim5.entiies.Etudiant> Etudiant;



        }
