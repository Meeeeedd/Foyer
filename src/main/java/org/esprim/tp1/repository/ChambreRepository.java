package org.esprim.tp1.repository;

import org.esprim.tp1.entity.Chambre;
import org.esprim.tp1.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List <Chambre> findAllByNumeroChambreIn (List<Long> numeroChambre);

    @Query(
            "SELECT c " +
            "FROM Chambre c " +
            "WHERE c.bloc.foyer.universite.nomUniversite =: nom")
    List <Chambre> trouverChambresParNomUniversite(@Param("nom") String nomUniversite);

    @Query(
            "SELECT c " +
                    "FROM Chambre c " +
                    "WHERE c.typeChambre =: typeC AND c.bloc.idBloc =: idBloc"

    )
    List <Chambre> getChambreParBlocEtType (@Param("typeC") TypeChambre typeC, @Param("idBloc") long idBloc);

}
