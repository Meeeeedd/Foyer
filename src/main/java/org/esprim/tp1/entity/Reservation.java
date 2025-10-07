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

    // Note: UML specifies idReservation: String. Using String for ID here.
    @Id
    private String idReservation;

    private Date anneeUniversitaire;
    private Boolean estValide;

    // Reservation (*) to Chambre (1) -> ManyToOne (Owning side)
    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    // Reservation (*) to Etudiant (*) -> ManyToMany (Owning side)
    // The diagram has a line between Reservation and Etudiant with '*' on both ends.
    @ManyToMany
    @JoinTable(
            name = "reservation_etudiant",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )
    private Set<Etudiant> etudiants;
}