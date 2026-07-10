package com.example.Enseignant.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enseignant_enseignants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long matiereId;
    private Long filiereId;
    private String matricule;
    private String photo;
    private String adresse;
    private String phone;
    private String cin;
    private String specialite;
    private String diplome;


}
