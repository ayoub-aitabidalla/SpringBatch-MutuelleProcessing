package com.example.GestionMutuelle.processor;

import com.example.GestionMutuelle.entities.Dossier;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalculProcessor implements ItemProcessor<Dossier, Dossier> {

    private final ConsultationProcess consultationProcessor;
    private final MappingProcessor traitementMappingProcessor;
    private final TraitementRemboursementProcessor traitementRemboursementProcessor;
    private final TotalRemboursementProcessor totalRemboursementProcessor;

    @Override
    public Dossier process(Dossier dossier) throws Exception {
        dossier = consultationProcessor.process(dossier);
        dossier = traitementMappingProcessor.process(dossier);
        dossier = traitementRemboursementProcessor.process(dossier);
        dossier = totalRemboursementProcessor.process(dossier);
        return dossier;
    }
}