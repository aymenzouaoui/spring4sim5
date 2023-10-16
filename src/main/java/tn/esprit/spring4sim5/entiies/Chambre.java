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
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idchambre;
    private long numchmbre;
    @Enumerated(EnumType.STRING)
    private Typechambre typec;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="Chambre")
    private Set<tn.esprit.spring4sim5.entiies.Bloc> Bloc;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
