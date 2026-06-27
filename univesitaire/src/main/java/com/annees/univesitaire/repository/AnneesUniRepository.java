package com.annees.univesitaire.repository;

import com.annees.univesitaire.entity.AnneesUniv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnneesUniRepository extends JpaRepository<AnneesUniv, Long>  {
    Optional<AnneesUniv> findByActifTrue();

    boolean existsByLibelle(String libelle);

}
