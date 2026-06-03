package com.mots.president.controller;

import com.mots.president.entity.MotsPresident;
import com.mots.president.service.MotsPresidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/mots")
@RequiredArgsConstructor
public class MotsPresidentController {

    private final MotsPresidentService service;

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public MotsPresident save(
            @RequestParam String nomPresident,
            @RequestParam String titre,
            @RequestParam String description,
            @RequestParam MultipartFile file
            ) {
        return service.save(nomPresident, titre, description, file);
    }

    @GetMapping
    public Page<MotsPresident> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public MotsPresident getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public MotsPresident update(
            @PathVariable Long id,
            @RequestParam String nomPresident,
            @RequestParam String titre,
            @RequestParam String description,
            @RequestParam(required = false) MultipartFile file
    ) {
        return service.update(id, nomPresident, titre, description, file);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}

