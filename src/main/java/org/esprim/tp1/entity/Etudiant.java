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
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String nomEt;
    private String prenomEt;
    private Long cin; // Assuming Long based on the type (cin: long)
    private String ecole;
    private Date dateNaissance;

    // Etudiant (*) to Reservation (*) -> ManyToMany (Non-owning side)
    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;
}