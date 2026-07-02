package com.etec.slides.repository;

import com.etec.slides.entity.Slide;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlideRepository extends JpaRepository<Slide, Long> {
    Page<Slide> findByActiveTrue(Pageable pageable);
}
