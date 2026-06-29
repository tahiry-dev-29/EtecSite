package com.etudiant.note.Dto;

import lombok.Data;

@Data
public class EtudiantResponse {
    private Long id;

    private String matricule;
    private String typeFormation;
}
