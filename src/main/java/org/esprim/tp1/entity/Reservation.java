package org.esprim.tp1.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation implements Serializable {

    @Id
    private Long idReservation;

    private Date anneeUniversitaire;
    private Boolean estValide;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;
}