package com.coursenligne.service;

import com.coursenligne.entity.Ressource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RessourceService {

    Ressource uploadFichier(MultipartFile file, Long chapitreId) throws IOException;

    Page<Ressource> getByChapitre(Long chapitreId, Pageable pageable);
}
