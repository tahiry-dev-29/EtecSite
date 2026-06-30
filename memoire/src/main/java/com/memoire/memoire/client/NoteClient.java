package com.memoire.memoire.client;

import com.memoire.memoire.dto.NoteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "NOTE")
public interface NoteClient {
    @GetMapping("/api/notes/{id}")
    NoteDto findById(@PathVariable Long id);
}
