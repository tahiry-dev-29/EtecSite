package com.coursenligne.service.impl;


import com.coursenligne.entity.Chapitre;
import com.coursenligne.entity.Leçon;

import com.coursenligne.repository.ChapitreRepository;
import com.coursenligne.repository.LeçonRepository;

import com.coursenligne.service.LeçonService;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;



@Service
@RequiredArgsConstructor
public class LeçonServiceImpl implements LeçonService {



    private final LeçonRepository leçonRepository;

    private final ChapitreRepository chapitreRepository;





    // Création d'une leçon
    @Override
    public Leçon creerLecon(
            Leçon leçon) {


        Long chapitreId =
                leçon.getChapitre()
                        .getId();



        Chapitre chapitre =
                chapitreRepository.findById(chapitreId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Chapitre introuvable"
                                )
                        );



        leçon.setChapitre(chapitre);



        return leçonRepository.save(leçon);
    }








    // Modification d'une leçon
    @Override
    public Leçon modifierLecon(
            Long id,
            Leçon leçon) {



        Leçon ancienne =
                leçonRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Leçon introuvable"
                                )
                        );



        ancienne.setTitre(
                leçon.getTitre()
        );


        ancienne.setContenu(
                leçon.getContenu()
        );


        ancienne.setDuree(
                leçon.getDuree()
        );



        return leçonRepository.save(ancienne);
    }








    // Toutes les leçons
    @Override
    public List<Leçon> getAll() {


        return leçonRepository.findAll();

    }








    // Une leçon par ID
    @Override
    public Leçon getById(
            Long id) {


        return leçonRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Leçon introuvable avec id : "
                                        + id
                        )
                );

    }








    // Leçons d'un chapitre
    @Override
    public List<Leçon> getByChapitreId(
            Long chapitreId) {


        return leçonRepository
                .findByChapitreIdOrderByIdAsc(
                        chapitreId
                );

    }








    // Suppression
    @Override
    public void supprimerLecon(
            Long id) {


        Leçon leçon =
                getById(id);


        leçonRepository.delete(leçon);

    }

}