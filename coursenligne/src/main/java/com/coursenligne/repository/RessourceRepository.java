package com.coursenligne.repository;

import com.coursenligne.entity.Ressource;
import com.coursenligne.entity.TypeRessource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {

    // récupérer les ressources d'une leçon
    List<Ressource> findByLeconId(Long leconId);

    // rechercher par type PDF, VIDEO, etc.
    List<Ressource> findByType(
            TypeRessource type
    );
}
