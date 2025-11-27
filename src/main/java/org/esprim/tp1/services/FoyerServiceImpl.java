package org.esprim.tp1.services;

import org.esprim.tp1.entity.Bloc;
import org.esprim.tp1.entity.Foyer;
import org.esprim.tp1.entity.Universite;
import org.esprim.tp1.repository.FoyerRepository;
import org.esprim.tp1.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {

    @Autowired
    private FoyerRepository foyerRepository;
    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Long idUniversite) {
        Universite universite = universiteRepository
                .findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université introuvable"));

        if (universite.getFoyer() != null)
            throw new RuntimeException("Cette université est associée à un foyer");

        if (foyer.getBlocs() != null)
            foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));

        List<Bloc> listBlocs = foyer.getBlocs();

       /*
       for (Bloc bloc : foyer.getBlocs()) {
          bloc.setFoyer(foyer);
        }
       */

        Foyer savedFoyer = foyerRepository.save(foyer);
        universite.setFoyer(savedFoyer);
        universiteRepository.save(universite);

        return savedFoyer;
    }


}