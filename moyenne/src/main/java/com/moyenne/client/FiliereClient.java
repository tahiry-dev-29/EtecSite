package com.moyenne.client;

import com.moyenne.dto.FiliereDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FILIERES")
public interface FiliereClient {

    @GetMapping("/api/filieres/{id}")
    FiliereDto filiere(@PathVariable Long id);
}
