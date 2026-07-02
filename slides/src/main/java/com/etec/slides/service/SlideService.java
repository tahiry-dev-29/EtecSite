package com.etec.slides.service;

import com.etec.slides.entity.Slide;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface SlideService {

    Slide save(String titre, String description,Boolean active, MultipartFile file);
    Page<Slide> findAll(Pageable pageable);
    Slide findById(Long id);
    Slide update(Long id, String titre, String description, Boolean active, MultipartFile file);
    String delete(Long id);
}
