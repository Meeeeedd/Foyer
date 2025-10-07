package org.esprim.tp1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    @ManyToMany(mappedBy = "etudiants", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}