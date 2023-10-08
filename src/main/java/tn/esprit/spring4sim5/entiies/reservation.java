package tn.esprit.spring4sim5.entiies;

import jakarta.persistence.*;
import lombok.*;


import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
public class reservation implements Serializable
        {
        private Date anneuniversaire;
            private boolean estvalide;
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Setter(AccessLevel.NONE)
            private Long idreservation;


        }
