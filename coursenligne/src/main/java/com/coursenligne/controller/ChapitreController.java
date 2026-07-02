package com.coursenligne.controller;

import com.coursenligne.entity.Chapitre;
import com.coursenligne.service.ChapitreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chapitres")
@RequiredArgsConstructor
public class ChapitreController {

    private final ChapitreService service;

    @PostMapping
    public Chapitre create(@RequestBody Chapitre chapitre) {
        return service.creerChapitre(chapitre);
    }

    @GetMapping("/cours/{id}")
    public Page<Chapitre> getByCours(@PathVariable Long id, Pageable pageable) {
        return service.getByCours(id, pageable);
    }
}
