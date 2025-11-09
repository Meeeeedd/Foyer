package org.esprim.tp1.services;

import org.esprim.tp1.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer retrieveFoyer(Long idFoyer);
    Foyer addFoyer(Foyer f);
    Foyer updateFoyer(Foyer f);
    void removeFoyer(Long idFoyer);
}