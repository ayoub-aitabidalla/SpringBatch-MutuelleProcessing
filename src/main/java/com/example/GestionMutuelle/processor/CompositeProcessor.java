package com.example.GestionMutuelle.processor;

import com.example.GestionMutuelle.entities.Dossier;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class CompositeProcessor {

    private final ValidationProcess validationProcess;
    private final CalculProcessor calculProcessor;

    @Bean
    public CompositeItemProcessor<Dossier, Dossier> compositeItemProcessor() {
        CompositeItemProcessor<Dossier, Dossier> compositeProcessor = new CompositeItemProcessor<>();
        compositeProcessor.setDelegates(Arrays.asList(validationProcess, calculProcessor));
        return compositeProcessor;
    }
}