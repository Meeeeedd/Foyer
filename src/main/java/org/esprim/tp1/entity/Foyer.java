package org.esprim.tp1.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;
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
    @JoinColumn(name = "universite_id")
    private Universite universite;

    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL)
    private List<Bloc> blocs;
}