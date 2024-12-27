package tn.esprit.examen.ExamenTrain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Gare implements Serializable {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idGare;
    String nom;
    @Enumerated(EnumType.STRING)
    Ville localisation;
}
