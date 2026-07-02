package com.coursenligne.service.impl;

import com.coursenligne.entity.Chapitre;
import com.coursenligne.repository.ChapitreRepository;
import com.coursenligne.service.ChapitreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChapitreServiceImpl implements ChapitreService {

    private final ChapitreRepository repo;

    @Override
    public Chapitre creerChapitre(Chapitre chapitre) {
        return repo.save(chapitre);
    }

    @Override
    public Page<Chapitre> getByCours(Long coursId, Pageable pageable) {
        return repo.findByCoursId(coursId, pageable);
    }
}
