package com.moyenne.dto;

import lombok.Data;

@Data
public class NoteDto {
        private Long id;

        private Long etudiantId;

        private Long matiereId;

        private Long userId;

        private Long filiereId;

        private Long niveauId;

        private Long domaineId;


        private double valeur;

        private String mention;

}
