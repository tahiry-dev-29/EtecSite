package com.moyenne.service;

import com.moyenne.entity.Moyenne;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MoyenneService {

    Moyenne calculerMoyenne(Long etudiantId);

    Page<Moyenne> findAll(Pageable pageable);

    Moyenne findById(Long id);

    Moyenne findByEtudiantId(Long etudiantId);

    void delete(Long id);

}