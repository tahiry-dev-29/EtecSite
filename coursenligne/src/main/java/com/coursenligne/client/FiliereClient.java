package com.coursenligne.client;

import com.coursenligne.dto.FiliereDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FILIERE")
public interface FiliereClient {

    @GetMapping("/api/filieres/{id}")
    FiliereDTO filiereById(@PathVariable Long id);
}
