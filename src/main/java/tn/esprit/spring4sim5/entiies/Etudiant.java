package tn.esprit.spring4sim5.entiies;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;
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
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long idetudiant;
    private String nomE;
    private String prenome;
    private String ecole;
    private long cin;
    private Date date;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> res;

}
