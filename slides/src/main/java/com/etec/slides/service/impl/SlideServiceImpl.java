package com.etec.slides.service.impl;

import com.etec.slides.entity.Slide;
import com.etec.slides.repository.SlideRepository;
import com.etec.slides.service.SlideService;
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
public class SlideServiceImpl implements SlideService {

    private final SlideRepository slideRepository;
    private final String UPLOAD_DIR = "upload/";
    @Override
    public Slide save(String titre, String description, Boolean active, MultipartFile file) {

        try {
            File dir = new File(UPLOAD_DIR);
            if (dir.exists()) {
                dir.mkdirs();
            }

            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR, filename);
            Files.write(path, file.getBytes());

            Slide slide = new Slide();
            slide.setTitre(titre);
            slide.setDescription(description);
            slide.setActive(active);
            slide.setImage(filename);

            return slideRepository.save(slide);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de créer cette image");
        }
    }

    @Override
    public Page<Slide> findAll(Pageable pageable) {
        return slideRepository.findAll(pageable);
    }

    @Override
    public Slide findById(Long id) {
        return slideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slide introuvable"));
    }

    @Override
    public Slide update(Long id, String titre, String description, Boolean active, MultipartFile file) {

        Slide existing = findById(id);

        existing.setTitre(titre);
        existing.setDescription(description);
        existing.setActive(active);

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
            throw new RuntimeException("Erreur de moifier cette image");
        }
        return slideRepository.save(existing);
    }

    @Override
    public String delete(Long id) {
        Slide slide = findById(id);
        try{
            if (slide.getImage() != null) {
                File file = new File(UPLOAD_DIR + slide.getImage());
                if (file.exists()) {
                    boolean deleted = file.delete();

                    if (!deleted) {
                        return "Image non supprimer";
                    }
                }
            }
            slideRepository.deleteById(id);

            return "Slide Supprimmer avec succès";
        }catch (Exception e) {
            return "Erreur lors de la suppression";
        }



    }
}
