package com.coursenligne.service;

import com.coursenligne.entity.Chapitre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChapitreService {

    Chapitre creerChapitre(Chapitre chapitre);

    Page<Chapitre> getByCours(Long coursId, Pageable pageable);
}
