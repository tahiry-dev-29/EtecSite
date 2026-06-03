package com.abscence.presence.controller;

import com.abscence.presence.entity.Presence;
import com.abscence.presence.service.PresenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/presences")
@RequiredArgsConstructor
public class PresenceController {

    private final PresenceService service;

    @PostMapping("/save")
    public Presence save(@RequestBody Presence presence) {
        return service.save(presence);
    }

    @GetMapping
    public Page<Presence> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Presence getById(@PathVariable Long id) {
        return service.finById(id);
    }

    @PutMapping("/{id}")
    public Presence update(
            @PathVariable Long id,
            @RequestBody Presence presence
    ) {
        return service.update(id, presence);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
