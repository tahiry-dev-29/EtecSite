package com.coursenligne.service.impl;

import com.coursenligne.entity.Ressource;
import com.coursenligne.entity.TypeRessource;
import com.coursenligne.repository.RessourceRepository;
import com.coursenligne.service.RessourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class RessourceServiceImpl implements RessourceService {

    private final RessourceRepository repo;

    private final String UPLOAD_DIR = "/uploads/";

    @Override
    public Ressource uploadFichier(MultipartFile file, Long chapitreId) throws IOException {

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File destination = new File(UPLOAD_DIR + fileName);
        file.transferTo(destination);

        Ressource res = new Ressource();
        res.setTitre(file.getOriginalFilename());
        res.setUrl("/files/" + fileName);
        res.setChapitreId(chapitreId);

        // type simple basé sur extension
        if (file.getContentType().startsWith("video")) {
            res.setType(TypeRessource.VIDEO);
        } else {
            res.setType(TypeRessource.PDF);
        }

        return repo.save(res);
    }

    @Override
    public Page<Ressource> getByChapitre(Long chapitreId, Pageable pageable) {
        return repo.findByChapitreId(chapitreId, pageable);
    }
}