package com.coursenligne.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "coursenligne_cours")
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

    @OneToMany(
            mappedBy = "cours",
            cascade = CascadeType.ALL
    )

    private List<Chapitre> chapitres;
    private boolean actif;
}
