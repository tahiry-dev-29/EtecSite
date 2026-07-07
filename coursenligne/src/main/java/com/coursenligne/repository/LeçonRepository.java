package com.coursenligne.repository;

import com.coursenligne.entity.Leçon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LeçonRepository extends JpaRepository<Leçon, Long> {

    Page<Leçon> findByChapitreId(Long chapitreId, Pageable pageable);

    // Récupérer les leçons d'un chapitre triées
    List<Leçon> findByChapitreIdOrderByIdAsc(Long chapitreId);

}
