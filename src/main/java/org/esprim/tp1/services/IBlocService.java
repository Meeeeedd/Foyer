package org.esprim.tp1.services;

import org.esprim.tp1.entity.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    Bloc retrieveBloc(Long idBloc);
    void removeBloc(Long idBloc);

    Bloc affecterChambresABloc(List<Long> numChambres, Long idBloc);
}