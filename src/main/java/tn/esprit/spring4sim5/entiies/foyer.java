package tn.esprit.spring4sim5.entiies;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
public class foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idfoyer;
    private String nomFoyer;
    private long capacityFoyer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="Foyer")
    private Set<bloc> Bloc;

    @OneToOne
    private universite Universite;
}
