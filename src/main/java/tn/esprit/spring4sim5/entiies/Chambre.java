package tn.esprit.spring4sim5.entiies;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
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
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idchambre;

    private long numchmbre;
    @Enumerated(EnumType.STRING)
    private Typechambre typec;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="Chambre")
    private Set<Bloc> Bloc;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
