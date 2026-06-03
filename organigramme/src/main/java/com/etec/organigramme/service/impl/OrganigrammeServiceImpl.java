package com.etec.organigramme.service.impl;

import com.etec.organigramme.entity.Organigramme;
import com.etec.organigramme.repository.OrganigrammeRepository;
import com.etec.organigramme.service.OrganigrammeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganigrammeServiceImpl implements OrganigrammeService {

    private final OrganigrammeRepository repository;
    private final String UPLOAD_DIR = "upload/";
    @Override
    public Organigramme save(Organigramme organigramme, MultipartFile multipartFile) {

        try {
            File dir = new File(UPLOAD_DIR);
            if (dir.exists()) dir.mkdirs();

            String filename = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + filename);
            Files.write(path, multipartFile.getBytes());

            organigramme.setImage(filename);
            return repository.save(organigramme);
        } catch (IOException e) {
            throw new RuntimeException("Erreur de créer cette");
        }
    }

    @Override
    public Page<Organigramme> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Organigramme finById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organigramme introuvable"));
    }

    @Override
    public Organigramme update(Long id, Organigramme organigramme, MultipartFile multipartFile) {
        Organigramme existing = finById(id);

        existing.setTitre(organigramme.getTitre());
        existing.setDescription(organigramme.getDescription());

        try {
            if (multipartFile != null && !multipartFile.isEmpty()) {
                if (existing.getImage() != null) {
                    File old = new File(UPLOAD_DIR + existing.getImage());
                    if (old.exists()) old.delete();

                    String filename = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
                    Path path = Paths.get(UPLOAD_DIR + filename);
                    Files.write(path, multipartFile.getBytes());

                    existing.setImage(filename);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur de modifier cette image");
        }
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Organigramme organigramme = finById(id);

        if (organigramme.getImage() != null) {
            File file = new File(UPLOAD_DIR + organigramme.getImage());
            if (file.exists()) file.delete();
        }

        repository.deleteById(id);
    }
}
