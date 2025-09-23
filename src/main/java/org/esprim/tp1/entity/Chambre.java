package org.esprim.tp1.entity;

import jakarta.persistence.*;

@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;
}
