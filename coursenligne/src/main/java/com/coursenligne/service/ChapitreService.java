package com.coursenligne.service;

import com.coursenligne.entity.Chapitre;

import java.util.List;

public interface ChapitreService {


    // Créer un chapitre
    Chapitre creerChapitre(Chapitre chapitre);


    // Modifier un chapitre
    Chapitre modifierChapitre(Long id, Chapitre chapitre);


    // Récupérer tous les chapitres
    List<Chapitre> getAll();


    // Récupérer un chapitre par id
    Chapitre getById(Long id);


    // Récupérer les chapitres d'un cours
    List<Chapitre> getByCoursId(Long coursId);


    // Supprimer un chapitre
    void supprimerChapitre(Long id);

}