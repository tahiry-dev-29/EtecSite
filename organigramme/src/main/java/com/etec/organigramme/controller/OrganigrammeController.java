package com.etec.organigramme.controller;

import com.etec.organigramme.entity.Organigramme;
import com.etec.organigramme.service.OrganigrammeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/organigrammes")
@RequiredArgsConstructor
public class OrganigrammeController {

    private final OrganigrammeService service;

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Organigramme save(
            @RequestPart("organigramme") Organigramme organigramme,
            @RequestPart("file")MultipartFile multipartFile
            ) {
        return service.save(organigramme,multipartFile);
    }

    @GetMapping
    public Page<Organigramme> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Organigramme getById(Long id) {
        return service.finById(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Organigramme update(
            @PathVariable Long id,
            @RequestPart("Organigramme") Organigramme organigramme,
            @RequestPart(value = "file", required = false) MultipartFile multipartFile
    ) {
        return service.update(id, organigramme, multipartFile);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
