package tn.esprit.spring4sim5.entiies;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Table
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long iduniversite;
    private String nomnivercsite;
    private String adresse;
    @OneToOne(mappedBy="Universite")
    private tn.esprit.spring4sim5.entiies.Foyer Foyer;




}
