package com.example.GestionMutuelle.processor;

import com.example.GestionMutuelle.entities.Dossier;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component

public class ConsultationProcess implements ItemProcessor<Dossier, Dossier> {
    @Override
    public Dossier process(Dossier item) throws Exception {
        double remboursementConsultation = item.getPrixConsultation() * 0.5;
        item.setMontantRemboursementConsultation(remboursementConsultation);
        return item;
    }
}
