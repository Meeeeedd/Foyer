package org.esprim.tp1.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    private String nomUniversite;
    private String adresse;

    // Universite (1) to Foyer (1) -> OneToOne (Unidirectional: Universite knows Foyer)
    // Assuming Foyer is managed by one Universite and vice-versa.
    // If it's a 1-to-1, the Foyer side should own the relationship typically.
    // Let's make it Bidirectional for clarity.
    @OneToOne(mappedBy = "universite") // Use mappedBy on the non-owning side
    private Foyer foyer;
}