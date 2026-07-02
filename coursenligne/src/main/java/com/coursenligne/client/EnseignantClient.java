package com.coursenligne.client;

import com.coursenligne.dto.EnseignantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ENSEIGNANT")
public interface EnseignantClient {

        @GetMapping("/api/Enseignants/{id}")
        EnseignantDTO getEnseignantById(@PathVariable Long id);
    }
