package com.coursenligne.dto;

import com.coursenligne.entity.CoursEnLigne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoursResponse {

    private CoursEnLigne cours;
    private MatiereDTO matiere;
    private EnseignantDTO enseignant;
    private FiliereDTO filiere;
    private NiveauDTO niveau;
    private DomaineDTO domaine;
}
