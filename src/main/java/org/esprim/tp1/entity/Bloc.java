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
public class Bloc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;
    private Long capaciteBloc; // Assuming Long based on the type

    // Bloc (1) to Foyer (1) -> OneToOne (Owning side)
    @ManyToOne(cascade = CascadeType.ALL)
    private Foyer foyer;

    // Bloc (1) to Chambre (*) -> OneToMany
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc", fetch = FetchType.EAGER)
    private List<Chambre> chambres;
}