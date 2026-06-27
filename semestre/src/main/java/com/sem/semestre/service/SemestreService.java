package com.sem.semestre.service;

import com.sem.semestre.entity.Semestre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SemestreService {

    Semestre save(Semestre semestre);
    Page<Semestre> findAll(Pageable pageable);
    Semestre findById(Long id);
    Semestre update(Long id, Semestre semestre);
    void delete(Long id);
    Semestre activer(Long id);
    Semestre semestreActif();

}
