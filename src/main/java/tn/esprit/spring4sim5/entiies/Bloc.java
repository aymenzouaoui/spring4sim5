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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idbloc;

    private String nombloc;
    private long capacitybloc;
    @ManyToOne
    Chambre Chambre;

    @ManyToOne
    Foyer foyer;



}
