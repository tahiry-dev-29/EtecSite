package com.etec.slides.service;

import com.etec.slides.entity.Slide;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface SlideService {

    public Slide save(String titre, String description, MultipartFile file);
    Page<Slide> findAll(Pageable pageable);
    Slide findById(Long id);
    public Slide update(Long id, String titre, String description, MultipartFile file);
    String delete(Long id);
}
