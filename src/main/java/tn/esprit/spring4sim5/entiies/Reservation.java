package tn.esprit.spring4sim5.entiies;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

@Slf4j

@ToString
public class Reservation implements Serializable
        {
            @Id
            @GeneratedValue(strategy = GenerationType.SEQUENCE)
            @Setter(AccessLevel.NONE)
            private Long idreservation;
            private Date anneuniversaire;
            private boolean estvalide;

            @ManyToMany(mappedBy="reservation", cascade = CascadeType.ALL)
            private Set<Etudiant> Etudiant;



        }
