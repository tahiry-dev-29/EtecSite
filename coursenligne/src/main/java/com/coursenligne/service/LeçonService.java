package com.coursenligne.service;


import com.coursenligne.entity.Leçon;

import java.util.List;


public interface LeçonService {


    // Créer une leçon
    Leçon creerLecon(Leçon leçon);



    // Modifier une leçon
    Leçon modifierLecon(Long id, Leçon leçon);



    // Récupérer toutes les leçons
    List<Leçon> getAll();



    // Récupérer une leçon par id
    Leçon getById(Long id);



    // Récupérer les leçons d'un chapitre
    List<Leçon> getByChapitreId(Long chapitreId);



    // Supprimer une leçon
    void supprimerLecon(Long id);

}