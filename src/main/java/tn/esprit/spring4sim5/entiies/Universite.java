package tn.esprit.spring4sim5.entiies;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Table

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long iduniversite;
    private String nomnivercsite;
    private String adresse;
    @OneToOne(mappedBy="Universite")
    private Foyer foyer;




}
