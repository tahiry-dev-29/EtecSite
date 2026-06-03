package com.abscence.presence.service.impl;

import com.abscence.presence.entity.Presence;
import com.abscence.presence.repository.PresenceRepository;
import com.abscence.presence.service.PresenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PresenceServiceImpl implements PresenceService {

    private final PresenceRepository repository;
    @Override
    public Presence save(Presence presence) {
        return repository.save(presence);
    }

    @Override
    public Page<Presence> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Presence finById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Presence introuvable"));
    }

    @Override
    public Presence update(Long id, Presence presence) {
        Presence existing = finById(id);

        existing.setNom(presence.getNom());
        existing.setPrenom(presence.getPrenom());
        existing.setMatricule(presence.getMatricule());
        existing.setSignature(presence.getSignature());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Presence existing = finById(id);
        repository.delete(existing);
    }
}
