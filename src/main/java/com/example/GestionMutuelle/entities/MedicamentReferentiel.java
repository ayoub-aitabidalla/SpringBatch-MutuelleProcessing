package com.example.GestionMutuelle.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medicaments_referentiels")
public class MedicamentReferentiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomMedicament;

    @Column(nullable = false, name = "prix_reference")
    private Double prixReference;

    @Column(nullable = false, name = "pourcentage_remboursement")
    private Double pourcentageRemboursement;
}
