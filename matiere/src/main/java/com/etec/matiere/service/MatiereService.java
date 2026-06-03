package com.etec.matiere.service;

import com.etec.matiere.entity.Matiere;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MatiereService {
    Matiere save(Matiere matiere);
    Page<Matiere> findAll(Pageable pageable);
    Matiere findById(Long id);
    Matiere update(Long id, Matiere matiere);
    void delete(Long id);
}
