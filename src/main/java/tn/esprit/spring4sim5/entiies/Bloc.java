package tn.esprit.spring4sim5.entiies;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@Slf4j

public class Bloc implements Serializable {
    private String nombloc;

    private long capacitybloc;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idbloc;

    @ManyToOne
    Chambre Chambre;

    @ManyToOne
    Foyer Foyer;



}
