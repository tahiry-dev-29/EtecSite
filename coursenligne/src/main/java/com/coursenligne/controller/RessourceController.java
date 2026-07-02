package com.coursenligne.controller;

import com.coursenligne.entity.Ressource;
import com.coursenligne.service.RessourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/ressources")
@RequiredArgsConstructor
public class RessourceController {

    private final RessourceService service;

    @PostMapping("/upload/{chapitreId}")
    public Ressource upload(@RequestParam("file") MultipartFile file,
                            @PathVariable Long chapitreId) throws IOException {
        return service.uploadFichier(file, chapitreId);
    }

    @GetMapping("/chapitre/{id}")
    public Page<Ressource> getByChapitre(@PathVariable Long id, Pageable pageable) {
        return service.getByChapitre(id, pageable);
    }
}
