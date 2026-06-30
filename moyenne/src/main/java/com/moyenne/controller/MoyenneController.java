package com.moyenne.controller;

import com.moyenne.entity.Moyenne;
import com.moyenne.service.MoyenneService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/moyennes")
@RequiredArgsConstructor
public class MoyenneController {

    private final MoyenneService moyenneService;

    // Calculer et enregistrer la moyenne d'un étudiant
    @PostMapping("/calcul/{etudiantId}")
    public ResponseEntity<Moyenne> calculerMoyenne(
            @PathVariable Long etudiantId) {

        return ResponseEntity.ok(
                moyenneService.calculerMoyenne(etudiantId)
        );
    }

    // Afficher toutes les moyennes
    @GetMapping
    public Page<Moyenne> getAll(Pageable pageable) {
        return moyenneService.findAll(pageable);
    }

    // Rechercher une moyenne par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Moyenne> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                moyenneService.findById(id)
        );
    }

    // Rechercher la moyenne d'un étudiant
    @GetMapping("/etudiant/{etudiantId}")
    public ResponseEntity<Moyenne> getByEtudiant(
            @PathVariable Long etudiantId) {

        return ResponseEntity.ok(
                moyenneService.findByEtudiantId(etudiantId)
        );
    }

    // Supprimer une moyenne
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        moyenneService.delete(id);
        return ResponseEntity.noContent().build();
    }
}