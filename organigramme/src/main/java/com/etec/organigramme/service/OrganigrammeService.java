package com.etec.organigramme.service;

import com.etec.organigramme.entity.Organigramme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface OrganigrammeService {

    Organigramme save(Organigramme organigramme, MultipartFile multipartFile);
    Page<Organigramme> findAll(Pageable pageable);
    Organigramme finById(Long id);
    Organigramme update(Long id, Organigramme organigramme, MultipartFile multipartFile);
    void delete(Long id);

}
