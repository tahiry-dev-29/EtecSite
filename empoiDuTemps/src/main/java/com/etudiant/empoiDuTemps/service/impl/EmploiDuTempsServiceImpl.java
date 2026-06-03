package com.etudiant.empoiDuTemps.service.impl;

import com.etudiant.empoiDuTemps.entity.EmploiDuTemps;
import com.etudiant.empoiDuTemps.repository.EmploiDuTempsRepository;
import com.etudiant.empoiDuTemps.service.EmploiDuTempsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmploiDuTempsServiceImpl implements EmploiDuTempsService {

    private final EmploiDuTempsRepository repository;
    @Override
    public EmploiDuTemps save(EmploiDuTemps emploiDuTemps) {
        return repository.save(emploiDuTemps);
    }

    @Override
    public Page<EmploiDuTemps> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public EmploiDuTemps finById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emploi du temps introuvable"));
    }

    @Override
    public EmploiDuTemps update(Long id, EmploiDuTemps emploiDuTemps) {
        EmploiDuTemps existing = finById(id);

        existing.setDate(emploiDuTemps.getDate());
        existing.setHeureDebut(emploiDuTemps.getHeureDebut());
        existing.setHeureFin(emploiDuTemps.getHeureFin());
        existing.setAnneesUniversitaire(emploiDuTemps.getAnneesUniversitaire());
        existing.setSemstre(emploiDuTemps.getSemstre());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
