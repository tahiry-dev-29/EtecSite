package com.etec.actualite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.nio.file.Paths;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Démarre du dossier racine où l'application s'exécute
        String uploadPath = Paths.get("uploads").toAbsolutePath().toUri().toString();

        // Tout mapping arrivant sur /uploads/** ira chercher dans le dossier physique uploads/
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(uploadPath);
    }
}
