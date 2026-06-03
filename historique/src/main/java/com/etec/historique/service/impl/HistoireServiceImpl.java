package com.etec.historique.service.impl;

import com.etec.historique.entity.Historique;
import com.etec.historique.repository.HistoireRepository;
import com.etec.historique.service.HistoireService;
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
public class HistoireServiceImpl implements HistoireService {

    private final HistoireRepository histoireRepository;
    private final String UPLOAD_DIR = "uploads/";
    @Override
    public Historique save(String nom, String description, MultipartFile multipartFile) {

        try {
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String filename = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR, filename);
            Files.write(path, multipartFile.getBytes());

            Historique historique = new Historique();
            historique.setNom(nom);
            historique.setDescription(description);
            historique.setImage(filename);

            return histoireRepository.save(historique);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de créer cette image");
        }
    }

    @Override
    public Page<Historique> findAll(Pageable pageable) {
        return histoireRepository.findAll(pageable);
    }

    @Override
    public Historique findById(Long id) {
        return histoireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Histoire Introuvable"));
    }

    @Override
    public Historique update(Long id, String nom, String description, MultipartFile multipartFile) {
        Historique existing = findById(id);

        existing.setNom(nom);
        existing.setDescription(description);

        try{
            if (multipartFile != null && !multipartFile.isEmpty()) {
                if (existing.getImage() != null) {
                    File old = new File(UPLOAD_DIR + existing.getImage());
                    if (old.exists()) old.delete();
                }

                String filename = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
                Path path = Paths.get(UPLOAD_DIR, filename);
                Files.write(path, multipartFile.getBytes());

                existing.setImage(filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de modifier l'image");
        }
        return histoireRepository.save(existing);
    }

    @Override
    public String delete(Long id) {
        Historique historique = findById(id);

        try {
            if (historique.getImage() != null) {
                File file = new File(UPLOAD_DIR + historique.getImage());
                if (file.exists()){
                    boolean deleted = file.delete();
                    if (!deleted) {
                        return "Image non supprimer";
                    }
                }
            }

            histoireRepository.deleteById(id);
            return "Historique supprimer avec succès";
        } catch (Exception e) {
            return "Erreur lors de la suppression";
        }
        }

}
