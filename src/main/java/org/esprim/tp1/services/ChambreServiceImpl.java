package org.esprim.tp1.services;

import org.esprim.tp1.entity.Chambre;
import org.esprim.tp1.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;

    @Autowired
    public ChambreServiceImpl(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambre(Long chambreId) {
        // repository's findById returns Optional<Chambre> from JpaRepository
        if (chambreId == null) return null;
        return chambreRepository.findById(chambreId).get();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void removeChambre(Long chambreId) {
        if (chambreId != null) {
            chambreRepository.deleteById(chambreId);
        }
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }
}
