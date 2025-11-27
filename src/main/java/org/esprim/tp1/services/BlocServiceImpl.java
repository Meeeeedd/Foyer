package org.esprim.tp1.services;

import org.esprim.tp1.entity.Bloc;
import org.esprim.tp1.entity.Chambre;
import org.esprim.tp1.entity.Foyer;
import org.esprim.tp1.entity.Universite;
import org.esprim.tp1.repository.BlocRepository;
import org.esprim.tp1.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BlocServiceImpl implements IBlocService {

    @Autowired
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {

        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc bloc) {

        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {

        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {

        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(Long idBloc) {

        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, Long idBloc) {

        Bloc bloc = blocRepository.findById(idBloc).orElseThrow(
                () -> new RuntimeException("Bloc introuvable avec l'ID: " + idBloc)
        );

        List<Chambre> chambres = chambreRepository.findAllByNumeroChambreIn(numChambres);

        if (chambres.size() != numChambres.size())
            throw new RuntimeException("Une ou plusieurs " + "chambres sont introuvable.");

        for (Chambre chambre : chambres){
            if (chambre.getBloc() != null
                    && chambre.getBloc().getIdBloc() != idBloc) {
                throw new RuntimeException(
                        "La chambre "
                        + chambre.getNumeroChambre()
                        + " est déjà affectée à un autre bloc.");
            }
        }

        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }

        blocRepository.save(bloc);
        chambreRepository.saveAll(chambres);
        return bloc;

        /* Collect existing chamber IDs to optimize existence check
        Set<Long> existingChambreIds = bloc.getChambres().stream()
                .map(Chambre::getIdChambre)
                .collect(Collectors.toSet());

        // Check if any chamber is already assigned
        for (Long numChambre : numChambres) {
            if (existingChambreIds.contains(numChambre)) {
                throw new RuntimeException("La chambre avec le numéro " + numChambre + " est déjà assignée à un bloc.");
            }
        }

        // Assign chambers to bloc
        for (Long numChambre : numChambres) {
            Chambre chambre = new Chambre();
            chambre.setIdChambre(numChambre);
            chambre.setBloc(bloc);
            bloc.getChambres().add(chambre);
        }
*/
    }
}

