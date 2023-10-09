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
public class chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idchambre;
    private long numchmbre;
    @Enumerated(EnumType.STRING)
    private typechambre typec;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="Chambre")
    private Set<bloc> Bloc;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<reservation> reservations;

}
