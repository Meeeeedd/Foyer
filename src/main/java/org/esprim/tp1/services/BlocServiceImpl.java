package org.esprim.tp1.services;

import org.esprim.tp1.entity.Bloc;
import org.esprim.tp1.repository.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService {

    @Autowired
    BlocRepository blocRepository;

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
}

