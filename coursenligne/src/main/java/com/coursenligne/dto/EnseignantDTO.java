package com.coursenligne.dto;

import lombok.Data;

@Data
public class EnseignantDTO {
    private Long id;
    private Long userId;
    private String matricule;
    private String specialite;
}
