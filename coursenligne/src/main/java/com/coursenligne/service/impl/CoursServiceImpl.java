package com.coursenligne.service.impl;

import com.coursenligne.client.*;
import com.coursenligne.dto.*;
import com.coursenligne.entity.CoursEnLigne;
import com.coursenligne.repository.CourEnLigneRepository;
import com.coursenligne.service.CoursEnLigneService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoursServiceImpl implements CoursEnLigneService {

    private final CourEnLigneRepository repo;
    private final EnseignantClient enseignantClient;
    private final MatiereClient matiereClient;
    private final FiliereClient filiereClient;
    private final NiveauClient niveauClient;
    private final DomaineClient domaineClient;

    @Override
    public CoursEnLigne creerCours(CoursEnLigne cours) {
        return repo.save(cours);
    }

    @Override
    public Page<CoursEnLigne> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public CoursEnLigne getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public CoursResponse getCoursById(Long id) {

        // 1. récupérer le cours local
        CoursEnLigne cours = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours introuvable"));

        MatiereDTO matiere = matiereClient.getMatiereById(cours.getMatiereId());
        EnseignantDTO enseignant = enseignantClient.getEnseignantById(cours.getEnseignantId());
        FiliereDTO filiere = filiereClient.filiereById(cours.getMatiereId());
        NiveauDTO niveau = niveauClient.niveauById(cours.getNiveauId());
        DomaineDTO domaine = domaineClient.domaineById(cours.getDomaineId());


        // 4. assembler la réponse
        return new CoursResponse(cours, matiere, enseignant, filiere, niveau, domaine);
    }
}
