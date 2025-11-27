package org.esprim.tp1.services;

import lombok.AllArgsConstructor;
import org.esprim.tp1.entity.Foyer;
import org.esprim.tp1.entity.Universite;
import org.esprim.tp1.repository.FoyerRepository;
import org.esprim.tp1.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

    private FoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void removeUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(
                        () -> new RuntimeException("Foyer introuvable avec l'ID: " + idFoyer)
                );

        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(
                        () -> new RuntimeException("Université introuvable avec le nom : " + nomUniversite)
                );

        if (foyer.getUniversite() != null || universite.getFoyer() != null) {
            throw new RuntimeException(
                    "L'association existe déjà pour ce foyer" + " ou cette université."
            );
        }

        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        universiteRepository.save(universite);
        foyerRepository.save(foyer);
        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(
                        () -> new RuntimeException("Université introuvable avec l'ID: " + idUniversite)
                );

        Foyer foyer = universite.getFoyer();
        if (foyer == null) {
            throw new RuntimeException("Aucun foyer associé à cette université.");
        }

        universite.setFoyer(null);
        foyer.setUniversite(null);
        universiteRepository.save(universite);
        foyerRepository.save(foyer);
        return universite;
    }
}