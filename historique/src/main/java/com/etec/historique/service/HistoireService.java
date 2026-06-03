package com.etec.historique.service;

import com.etec.historique.entity.Historique;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface HistoireService {
    Historique save(String nom, String description, MultipartFile file);
    Page<Historique> findAll(Pageable pageable);
    Historique findById(Long id);
    Historique update(Long id, String nom,  String description, MultipartFile multipartFile);
    String delete(Long id);
}
