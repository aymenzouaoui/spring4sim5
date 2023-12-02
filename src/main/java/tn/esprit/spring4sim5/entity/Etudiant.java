package tn.esprit.spring4sim5.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idEtudiant;

    private String nomEt;

    private String prenomEt;

    private Long cin;

    private String ecole;

    private Date dateNaissance;


    @ManyToMany(mappedBy="etudiants")
    private Set<Reservation> reservations;




}
