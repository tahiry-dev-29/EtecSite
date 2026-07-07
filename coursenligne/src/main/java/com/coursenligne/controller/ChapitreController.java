package com.coursenligne.controller;


import com.coursenligne.entity.Chapitre;
import com.coursenligne.service.ChapitreService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/chapitres")
@RequiredArgsConstructor
public class ChapitreController {



    private final ChapitreService chapitreService;




    // =========================
    // Créer un chapitre
    // =========================
    @PostMapping
    public ResponseEntity<Chapitre> creerChapitre(
            @RequestBody Chapitre chapitre
    ){

        Chapitre nouveau =
                chapitreService.creerChapitre(chapitre);


        return new ResponseEntity<>(
                nouveau,
                HttpStatus.CREATED
        );
    }





    // =========================
    // Modifier un chapitre
    // =========================
    @PutMapping("/{id}")
    public ResponseEntity<Chapitre> modifierChapitre(
            @PathVariable Long id,
            @RequestBody Chapitre chapitre
    ){

        Chapitre modifier =
                chapitreService.modifierChapitre(
                        id,
                        chapitre
                );


        return ResponseEntity.ok(modifier);
    }





    // =========================
    // Récupérer tous les chapitres
    // =========================
    @GetMapping
    public ResponseEntity<List<Chapitre>> getAll(){

        return ResponseEntity.ok(
                chapitreService.getAll()
        );
    }





    // =========================
    // Récupérer un chapitre par ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<Chapitre> getById(
            @PathVariable Long id
    ){

        return ResponseEntity.ok(
                chapitreService.getById(id)
        );
    }





    // =========================
    // Récupérer les chapitres d'un cours
    // =========================
    @GetMapping("/cours/{coursId}")
    public ResponseEntity<List<Chapitre>> getByCoursId(
            @PathVariable Long coursId
    ){

        return ResponseEntity.ok(
                chapitreService.getByCoursId(coursId)
        );
    }





    // =========================
    // Supprimer un chapitre
    // =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable Long id
    ){

        chapitreService.supprimerChapitre(id);


        return ResponseEntity.noContent()
                .build();
    }

}