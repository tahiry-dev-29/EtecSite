package com.etudiant.note.Dto;

import lombok.Data;

@Data
public class EtudiantResponse {
    private Long id;

    private String matricule;

    private UserDto user;

    private FiliereDto filiere;

    private NiveauDto niveau;

    private DomaineDto domaine;

    private String typeFormation;
}
