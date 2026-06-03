package com.abscence.presence.service;

import com.abscence.presence.entity.Presence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PresenceService {
    Presence save(Presence presence);
    Page<Presence> findAll(Pageable pageable);
    Presence finById(Long id);
    Presence update(Long id, Presence presence);
    void delete(Long id);
}
