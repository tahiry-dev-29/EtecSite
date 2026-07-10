package com.coursenligne.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "coursenligne_videos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String urlVideo;

    private Integer duree;

    @ManyToOne
    @JoinColumn(name="leçon_id")
    private Leçon leçon;
}
