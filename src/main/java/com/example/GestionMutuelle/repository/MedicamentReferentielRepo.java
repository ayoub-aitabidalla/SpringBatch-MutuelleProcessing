package com.example.GestionMutuelle.repository;

import com.example.GestionMutuelle.entities.MedicamentReferentiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentReferentielRepo extends JpaRepository<MedicamentReferentiel,Long> {
    MedicamentReferentiel findByNomMedicament(String nom);
}
