package com.etudiant.note.client;

import com.etudiant.note.Dto.NiveauDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="NIVEAU")
public interface NiveauClient {

    @GetMapping("/api/niveau/{id}")
    NiveauDto getNiveau(@PathVariable Long id);
}
