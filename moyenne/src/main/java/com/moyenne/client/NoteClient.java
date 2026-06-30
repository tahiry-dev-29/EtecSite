package com.moyenne.client;

import com.moyenne.dto.NoteDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface NoteClient {
    @GetMapping("/api/notes/etudiant/{id}")
    List<NoteDto> getNotes(
            @PathVariable("id") Long id
    );

}
