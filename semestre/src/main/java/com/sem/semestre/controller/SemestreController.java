package com.sem.semestre.controller;

import com.sem.semestre.entity.Semestre;
import com.sem.semestre.service.SemestreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/semestres")
@RequiredArgsConstructor
public class SemestreController {

    private final SemestreService service;

    @PostMapping("/save")
    public Semestre save(@RequestBody Semestre semestre) {
        return service.save(semestre);
    }

    @GetMapping
    public Page<Semestre> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Semestre getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/id")
    public Semestre update(
            @PathVariable Long id,
            @RequestBody Semestre semestre
    ) {
        return service.update(id, semestre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}/activer")
    public ResponseEntity<Semestre> activer(@PathVariable Long id) {

        return ResponseEntity.ok(service.activer(id));
    }

    @GetMapping("/actif")
    public ResponseEntity<Semestre> actif() {

        return ResponseEntity.ok(service.semestreActif());
    }

}
