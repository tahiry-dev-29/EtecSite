package com.coursenligne.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cours")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursEnLigne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Column(length = 2000)
    private String description;

    private Long matiereId;

    private Long enseignantId;

    private Long filiereId;

    private Long niveauId;

    private Long domaineId;

    private boolean actif;
}
