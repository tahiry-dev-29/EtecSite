package com.coursenligne.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chapitres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapitre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Column(length = 3000)
    private String description;

    private Integer ordre;

    private Long coursEnLigneId;
}
