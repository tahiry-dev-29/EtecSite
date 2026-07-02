package com.coursenligne.client;

import com.coursenligne.dto.MatiereDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MATIERE")
public interface MatiereClient {

    @GetMapping("/api/matieres/{id}")
    MatiereDTO getMatiereById(@PathVariable Long id);
}
