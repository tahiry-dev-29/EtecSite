package com.coursenligne.repository;

import com.coursenligne.entity.Chapitre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapitreRepository extends JpaRepository<Chapitre, Long> {

    Page<Chapitre> findByCoursId(Long coursId, Pageable pageable);

    // Récupérer les chapitres d'un cours triés par ordre
    List<Chapitre> findByCoursIdOrderByOrdreAsc(Long coursId);
}
