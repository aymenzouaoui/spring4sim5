package tn.esprit.spring4sim5.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;

    private Long capaciteBloc;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Foyer foyer;

    @OneToMany(mappedBy="bloc")
    private Set<Chambre> chambres;
}
