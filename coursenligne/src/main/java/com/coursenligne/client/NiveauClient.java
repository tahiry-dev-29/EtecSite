package com.coursenligne.client;

import com.coursenligne.dto.NiveauDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "NIVEAU")
public interface NiveauClient {

    @GetMapping("/api/niveau/{id}")
    NiveauDTO niveauById(@PathVariable Long id);
}
