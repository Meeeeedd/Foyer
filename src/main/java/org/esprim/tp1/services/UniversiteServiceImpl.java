package org.esprim.tp1.services;

import org.esprim.tp1.entity.Universite;
import org.esprim.tp1.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

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
}