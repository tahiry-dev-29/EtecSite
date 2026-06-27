package com.annees.univesitaire.service;

import com.annees.univesitaire.entity.AnneesUniv;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnneesUnivService {
    AnneesUniv save(AnneesUniv anneesUniv);
    Page<AnneesUniv> findAll(Pageable pageable);
    AnneesUniv findById(Long id);
    AnneesUniv update(Long id, AnneesUniv anneesUniv);
    void delete(Long id);
    AnneesUniv activer(Long id);
    AnneesUniv anneesActive();

}
