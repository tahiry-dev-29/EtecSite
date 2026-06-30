package com.memoire.memoire.client;

import com.memoire.memoire.dto.EtudiantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ETUDIANT")
public interface EtudiantClient {

    @GetMapping("/etudiants/{id}")
    EtudiantDto findById(@PathVariable Long id);
}
