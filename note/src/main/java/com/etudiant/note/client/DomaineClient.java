package com.etudiant.note.client;

import com.etudiant.note.Dto.DomaineDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DOMAINE")
public interface DomaineClient {

    @GetMapping("/api/domaines/{id}")
    DomaineDto getDomaine(@PathVariable Long id);
}
