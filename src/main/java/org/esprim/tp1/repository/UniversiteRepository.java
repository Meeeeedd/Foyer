package org.esprim.tp1.repository;

import org.esprim.tp1.entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    Optional<Universite> findByNomUniversite(String nom);
}
