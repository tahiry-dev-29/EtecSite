package com.moyenne.repository;

import com.moyenne.entity.Moyenne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoyenneRepository extends JpaRepository<Moyenne, Long> {

    Optional<Moyenne> findByEtudiantId(Long etudiantId);
}
