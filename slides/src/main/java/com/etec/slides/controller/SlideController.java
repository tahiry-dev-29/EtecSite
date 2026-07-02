package com.etec.slides.controller;

import com.etec.slides.entity.Slide;
import com.etec.slides.service.SlideService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/slides")
@CrossOrigin("*")
@RequiredArgsConstructor
public class SlideController {

    private final SlideService slideService;

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Slide save(
            @RequestParam String titre,
            @RequestParam String description,
            @RequestParam Boolean active,
            @RequestParam MultipartFile file
    ) {
        return slideService.save(titre, description, active, file);
    }

    @GetMapping
    public Page<Slide> getAll(Pageable pageable) {
        return slideService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Slide getById(@PathVariable Long id) {
        return slideService.findById(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Slide update(
            @PathVariable Long id,
            @RequestParam String titre,
            @RequestParam String description,
            @RequestParam Boolean active,
            @RequestParam(required = false) MultipartFile file
    ) {
        return slideService.update(id, titre, description, active, file);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(slideService.delete(id));
    }

}
