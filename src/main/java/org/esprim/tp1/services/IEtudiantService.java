package org.esprim.tp1.services;

import org.esprim.tp1.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant retrieveEtudiant(Long idEtudiant);
    Etudiant addEtudiant(Etudiant e);
    Etudiant updateEtudiant(Etudiant e);
    void removeEtudiant(Long idEtudiant);
}