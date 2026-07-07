package com.coursenligne.dto;

import com.coursenligne.entity.CoursEnLigne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursResponse {

        private Long id;

        private String titre;

        private String description;

        private MatiereDTO matiere;

        private EnseignantDTO enseignant;

        private FiliereDTO filiere;

        private NiveauDTO niveau;

        private DomaineDTO domaine;
}
