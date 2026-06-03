package com.mots.president.service.impl;

import com.mots.president.entity.MotsPresident;
import com.mots.president.repository.MotsPresidentRepository;
import com.mots.president.service.MotsPresidentService;
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
public class MotsPresidentServiceImp implements MotsPresidentService {

    private final MotsPresidentRepository repository;
    private final String UPLOAD_DIR = "upload/";
    @Override
    public MotsPresident save(String nomPresident, String titre, String description, MultipartFile file) {

        try {
            File dir = new File(UPLOAD_DIR);
            if (dir.exists()) {
                dir.mkdirs();
            }

            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR, filename);
            Files.write(path, file.getBytes());

            MotsPresident motsPresident = new MotsPresident();
            motsPresident.setNomPresident(nomPresident);
            motsPresident.setTitre(titre);
            motsPresident.setDescription(description);
            motsPresident.setImage(filename);

            return repository.save(motsPresident);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de créer cette image");
        }

    }

    @Override
    public Page<MotsPresident> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public MotsPresident findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mots introuvable"));
    }

    @Override
    public MotsPresident update(Long id, String nomPresident, String titre, String description, MultipartFile file) {
        MotsPresident existing = findById(id);

        existing.setNomPresident(nomPresident);
        existing.setTitre(titre);
        existing.setDescription(description);

        try {
            if (file != null && !file.isEmpty()) {
                if (existing.getImage() != null) {
                    File old = new File(UPLOAD_DIR + existing.getImage());
                    if (old.exists()) old.delete();

                    String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
                    Path path = Paths.get(UPLOAD_DIR, filename);
                    Files.write(path, file.getBytes());

                    existing.setImage(filename);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de Modifier cette image");
        }
        return repository.save(existing);
    }

    @Override
    public String delete(Long id) {
        MotsPresident motsPresident = findById(id);

        try{
            if (motsPresident.getImage() != null) {
                File file = new File(UPLOAD_DIR + motsPresident.getImage());
                if (file.exists()) {
                    boolean deleted = file.delete();

                    if (!deleted) {
                        return "Image nom supprimer";
                    }
                }
            }

            repository.deleteById(id);

            return "Mots supprimer avec succès";
        } catch (Exception e) {
            return "Erreur lors de la suppression";
        }
        }

}
