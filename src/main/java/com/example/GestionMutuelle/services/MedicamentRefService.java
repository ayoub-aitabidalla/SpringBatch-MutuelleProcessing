package com.example.GestionMutuelle.services;

import com.example.GestionMutuelle.entities.MedicamentReferentiel;
import com.example.GestionMutuelle.repository.MedicamentReferentielRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentRefService {

    private final MedicamentReferentielRepo medicamentReferentielRepo;

    public MedicamentRefService(MedicamentReferentielRepo medicamentReferentielRepo) {
        this.medicamentReferentielRepo = medicamentReferentielRepo;
    }


    public MedicamentReferentiel getMedByName(String name) {
        return medicamentReferentielRepo.findByNomMedicament(name);
    }
}
