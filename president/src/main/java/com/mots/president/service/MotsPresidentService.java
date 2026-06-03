package com.mots.president.service;

import com.mots.president.entity.MotsPresident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface MotsPresidentService {

    MotsPresident save(String nomPresident, String titre, String description, MultipartFile file);
    Page<MotsPresident> findAll(Pageable pageable);
    MotsPresident findById(Long id);
    MotsPresident update(Long id, String nomPresident, String titre, String description, MultipartFile multipartFile);
    String delete(Long id);
}
