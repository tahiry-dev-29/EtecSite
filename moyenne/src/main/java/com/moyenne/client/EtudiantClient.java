package com.moyenne.client;

import com.moyenne.dto.EtudiantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ETUDIANT")
public interface EtudiantClient {

    @GetMapping("/etudiants/id/{id}")
    EtudiantDto etudiant(@PathVariable Long id);
}
