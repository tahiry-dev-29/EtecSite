package com.annees.univesitaire.controller;

import com.annees.univesitaire.entity.AnneesUniv;
import com.annees.univesitaire.service.AnneesUnivService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/anneesUniv")
public class AnneesUnivController {

    private final AnneesUnivService service;

    @PostMapping("/save")
    public AnneesUniv save(@RequestBody AnneesUniv anneesUniv) {
        return service.save(anneesUniv);
    }

    @GetMapping
    public Page<AnneesUniv> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public AnneesUniv getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public AnneesUniv update(
            @PathVariable Long id,
            @RequestBody AnneesUniv anneesUniv
    ) {
        return service.update(id, anneesUniv);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}/activer")
    public ResponseEntity<AnneesUniv> activer(@PathVariable Long id) {

        return ResponseEntity.ok(service.activer(id));
    }

    @GetMapping("/active")
    public ResponseEntity<AnneesUniv> active() {

        return ResponseEntity.ok(service.anneesActive());
    }
}
