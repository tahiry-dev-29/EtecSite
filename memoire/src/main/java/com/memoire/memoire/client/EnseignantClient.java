package com.memoire.memoire.client;

import com.memoire.memoire.dto.EnseignantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ENSEIGNANT")
public interface EnseignantClient {

    @GetMapping("/enseignants/{id}")
    EnseignantDto findById(@PathVariable Long id);
}
