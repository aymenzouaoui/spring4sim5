package tn.esprit.spring4sim5.entiies;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

@Slf4j

@ToString
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
