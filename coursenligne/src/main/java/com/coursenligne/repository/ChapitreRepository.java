package com.coursenligne.repository;

import com.coursenligne.entity.Chapitre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapitreRepository extends JpaRepository<Chapitre, Long> {

    Page<Chapitre> findByCoursId(Long coursId, Pageable pageable);
}
