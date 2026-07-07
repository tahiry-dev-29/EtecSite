package com.coursenligne.controller;


import com.coursenligne.dto.CoursResponse;
import com.coursenligne.entity.CoursEnLigne;
import com.coursenligne.service.CoursEnLigneService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/cours")
@RequiredArgsConstructor
public class CoursEnLigneController {



    private final CoursEnLigneService coursService;



    /**
     * Créer un cours
     */
    @PostMapping
    public ResponseEntity<CoursEnLigne> creerCours(
            @RequestBody CoursEnLigne cours
    ){

        CoursEnLigne nouveauCours =
                coursService.creerCours(cours);


        return new ResponseEntity<>(
                nouveauCours,
                HttpStatus.CREATED
        );
    }





    /**
     * Liste des cours avec pagination
     */
    @GetMapping
    public ResponseEntity<Page<CoursEnLigne>> getAll(
            Pageable pageable
    ){

        Page<CoursEnLigne> cours =
                coursService.getAll(pageable);


        return ResponseEntity.ok(cours);
    }






    /**
     * Récupérer un cours par ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<CoursEnLigne> getById(
            @PathVariable Long id
    ){

        CoursEnLigne cours =
                coursService.getById(id);


        return ResponseEntity.ok(cours);
    }






    /**
     * Récupérer un cours complet
     * avec Enseignant, Matière, Filière, Niveau
     */
    @GetMapping("/{id}/details")
    public ResponseEntity<CoursResponse> getCoursComplet(
            @PathVariable Long id
    ){

        CoursResponse response =
                coursService.getCoursById(id);


        return ResponseEntity.ok(response);
    }






    /**
     * Supprimer un cours
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ){

        coursService.delete(id);


        return ResponseEntity.noContent()
                .build();
    }

}