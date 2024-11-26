package com.example.GestionMutuelle.processor;

import com.example.GestionMutuelle.entities.Dossier;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ValidationProcess implements ItemProcessor<Dossier, Dossier> {
    @Override
    public Dossier process(Dossier item) throws Exception {
        if (item.getNomAssure() == null || item.getNomAssure().isEmpty()) {
                throw new IllegalArgumentException("Nom de l'assuré ne peut pas être vide");
            }
            if (item.getNumeroAffiliation() == null || item.getNumeroAffiliation().isEmpty()) {
                throw new IllegalArgumentException("Numéro d'affiliation ne peut pas être vide");
            }
            if (item.getPrixConsultation() <= 0) {
                throw new IllegalArgumentException("Prix de consultation doit être positif");
            }
            if (item.getMontantTotalFrais() <= 0) {
                throw new IllegalArgumentException("Montant total des frais doit être positif");
            }
            if (item.getTraitements() == null || item.getTraitements().isEmpty()) {
                throw new IllegalArgumentException("Liste des traitements ne peut pas être vide");
            }
        return item;
    }
}
