package com.annees.univesitaire.service.impl;

import com.annees.univesitaire.entity.AnneesUniv;
import com.annees.univesitaire.repository.AnneesUniRepository;
import com.annees.univesitaire.service.AnneesUnivService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnneesUnivServiceImpl implements AnneesUnivService {

    private final AnneesUniRepository repository;
    @Override
    public AnneesUniv save(AnneesUniv anneesUniv) {
        return repository.save(anneesUniv);
    }

    @Override
    public Page<AnneesUniv> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public AnneesUniv findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Années universitaire introuvable"));
    }

    @Override
    public AnneesUniv update(Long id, AnneesUniv anneesUniv) {
        AnneesUniv existing = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Années universitaire introuvable"));

        existing.setLibelle(anneesUniv.getLibelle());
        existing.setDebut(anneesUniv.getDebut());
        existing.setFin(anneesUniv.getFin());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        AnneesUniv existing = findById(id);
        repository.delete(existing);

    }

    @Override
    public AnneesUniv activer(Long id) {

        List<AnneesUniv> annees = repository.findAll();

        annees.forEach(a -> a.setActif(false));

        repository.saveAll(annees);

        AnneesUniv annee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Année universitaire introuvable."));

        annee.setActif(true);

        return repository.save(annee);
    }

    public AnneesUniv anneesActive() {

        return repository.findByActifTrue()
                .orElseThrow(() -> new RuntimeException("Aucune année universitaire active."));
    }

}
