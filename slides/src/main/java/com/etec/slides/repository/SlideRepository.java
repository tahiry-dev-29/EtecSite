package com.etec.slides.repository;

import com.etec.slides.entity.Slide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlideRepository extends JpaRepository<Slide, Long> {

}
