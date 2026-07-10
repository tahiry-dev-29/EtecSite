package com.moyenne.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "moyenne_moyennes")
public class Moyenne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long etudiantId;
    private Long userId;
    private Double moyenneGenerale;
    private String mention;
}
