package org.esprim.tp1.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set; // Use Set for better performance in OneToMany/ManyToMany

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chambre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    // Changed to Long as per UML diagram, though String might be more common for room numbers
    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre; // Renamed from typeC to typeChambre

    // Chambre (*) to Bloc (1) -> ManyToOne
    @ManyToOne
    private Bloc bloc;

    // Chambre (1) to Reservation (*) -> OneToMany
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}