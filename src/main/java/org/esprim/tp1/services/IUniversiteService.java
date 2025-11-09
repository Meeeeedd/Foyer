package org.esprim.tp1.services;

import org.esprim.tp1.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite retrieveUniversite(Long idUniversite);
    Universite addUniversite(Universite u);
    Universite updateUniversite(Universite u);
    void removeUniversite(Long idUniversite);
}
