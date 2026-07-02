package com.coursenligne.repository;

import com.coursenligne.entity.Ressource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {

    Page<Ressource> findByChapitreId(Long chapitreId, Pageable pageable);
}
