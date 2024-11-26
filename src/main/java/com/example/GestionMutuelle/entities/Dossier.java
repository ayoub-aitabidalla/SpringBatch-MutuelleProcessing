package com.example.GestionMutuelle.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomBeneficiaire;
    private String lienParente;
    private LocalDate dateDepotDossier;
    private double montantTotalFrais;
    private double prixConsultation;
    private int nombrePiecesJointes;
    private String nomAssure;
    private String numeroAffiliation;
    private String immatriculation;
    private double montantRemboursementConsultation;
    private double montantRemboursement;

    @OneToMany(mappedBy = "dossier", cascade = CascadeType.ALL)
    private List<Traitement> traitements;
}
