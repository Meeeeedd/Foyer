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
public class Foyer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;
    private Long capaciteFoyer; // Assuming Long based on the type

    // Foyer (1) to Universite (1) -> OneToOne (Owning side)
    @OneToOne
    @JoinColumn(name = "universite_id", referencedColumnName = "idUniversite")
    private Universite universite;

    // Foyer (1) to Bloc (1) -> OneToOne (Relationship is Foyer 1 to Bloc 1)
    // Given the diagram shows a line between Foyer and Bloc with '1' and '1',
    // it's a OneToOne. Let's make Bloc the owning side for practicality.
    @OneToOne(mappedBy = "foyer") // Non-owning side
    private Bloc bloc;
}