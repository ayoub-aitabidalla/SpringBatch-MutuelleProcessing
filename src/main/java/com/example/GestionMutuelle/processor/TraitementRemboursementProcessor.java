package com.example.GestionMutuelle.processor;

import com.example.GestionMutuelle.entities.Dossier;
import com.example.GestionMutuelle.entities.Traitement;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class TraitementRemboursementProcessor implements ItemProcessor<Dossier, Dossier> {

    @Override
    public Dossier process(Dossier dossier) {
        for (Traitement traitement : dossier.getTraitements()) {
            if (traitement.isExiste()) {
                double remboursementTraitement = traitement.getPrixMedicament() * (traitement.getPourcentageRemboursement() / 100);
                traitement.setMontantRemboursement(remboursementTraitement);
            } else {
                traitement.setMontantRemboursement(0.0);
            }
        }
        return dossier;
    }
}