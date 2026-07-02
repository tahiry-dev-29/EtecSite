package com.coursenligne.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ressources")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ressource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Enumerated(EnumType.STRING)
    private TypeRessource type;

    private String url;

    private Long chapitreId;
}