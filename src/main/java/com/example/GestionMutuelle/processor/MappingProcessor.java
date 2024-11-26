package com.example.GestionMutuelle.processor;

import com.example.GestionMutuelle.entities.Dossier;
import com.example.GestionMutuelle.entities.MedicamentReferentiel;
import com.example.GestionMutuelle.entities.Traitement;
import com.example.GestionMutuelle.services.MedicamentRefService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component

public class MappingProcessor implements ItemProcessor<Dossier,Dossier> {


    private final MedicamentRefService medicamentRefService;

    public MappingProcessor(MedicamentRefService medicamentRefService) {
        this.medicamentRefService = medicamentRefService;
    }

    @Override
    public Dossier process(Dossier item) throws Exception {
        for(Traitement traitement:item.getTraitements()){
            MedicamentReferentiel ref = medicamentRefService.getMedByName(traitement.getNomMedicament());
            if (ref != null) {
                traitement.setPrixMedicament(ref.getPrixReference());
                traitement.setPourcentageRemboursement(ref.getPourcentageRemboursement());
                traitement.setExiste(true);
            } else {
                traitement.setExiste(false);
            }
        }
        return item;
    }
}
