package com.api.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder,
                               JwtAuthenticationFilter filter) {

        return builder.routes()

                // =========================
                // UTILISATEUR SERVICE 
                // =========================
                .route("utilisateur", r -> r.path("/api/users/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://UTILISATEUR"))

                // =========================
                // COURS SERVICE
                // =========================
                .route("cours", r -> r.path("/api/cours/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURS"))

                // =========================
                // ADMIN SERVICE
                // =========================
                .route("admin", r -> r.path("/api/admin/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ADMIN"))

                // =========================
                // AUTH SERVICE (LOGIN PUBLIC)
                // =========================
                .route("auth", r -> r.path("/api/auth/**")
                        .uri("lb://UTILISATEUR")) // ou AUTH-SERVICE si tu as un service séparé

                // =========================
                // ETUDIANT SERVICE (optionnel si séparé)
                // =========================
                .route("etudiant", r -> r.path("/api/etudiant/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ETUDIANT"))

                // =========================
                // ENSEIGNANT SERVICE (optionnel si séparé)
                // =========================
                .route("enseignant", r -> r.path("/api/enseignant/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ENSEIGNANT"))

                // =========================
                // ACTUALITES SERVICE (PUBLIC)
                // =========================
                .route("actualites", r -> r.path("/api/actualites/**")
                        .uri("lb://ACTUALITE")) // Redirige vers le microservice enregistré sous le nom ACTUALITE sur Eureka

                // =========================
                // NEW GATEWAY ROUTES
                // =========================
                .route("domaines", r -> r.path("/api/domaines/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://DOMAINE"))

                .route("encadreurs", r -> r.path("/api/encadreurs/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ENCADREUR"))

                .route("encadrements", r -> r.path("/api/encadrements/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ENCADREMENT"))

                .route("emails", r -> r.path("/api/emails/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://EMAIL"))

                .route("emploiDuTemps", r -> r.path("/api/emploiDuTemps/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://EMPLOIDUTEMPS"))

                .route("filieres", r -> r.path("/api/filieres/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://FILIERE"))

                .route("formationInitiale", r -> r.path("/api/formationInitiale/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://FORMATIONINITIALE"))

                .route("formationContinue", r -> r.path("/api/formationContinue/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://FORMATIONCONTINUE"))

                .route("formationEnLigne", r -> r.path("/api/formationEnLigne/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://FORMATIONENLIGNE"))

                .route("historiques", r -> r.path("/api/historiques/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://HISTORIQUE"))

                .route("matieres", r -> r.path("/api/matieres/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://MATIERE"))

                .route("memoires", r -> r.path("/api/memoires/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://MEMOIRE"))

                .route("moyennes", r -> r.path("/api/moyennes/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://MOYENNE"))

                .route("niveau", r -> r.path("/api/niveau/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://NIVEAU"))

                .route("notes", r -> r.path("/api/notes/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://NOTE"))

                .route("notifications", r -> r.path("/api/notifications/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://NOTIFICATION"))

                .route("organigrammes", r -> r.path("/api/organigrammes/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ORGANIGRAMME"))

                .route("presences", r -> r.path("/api/presences/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://PRESENCE"))

                .route("mots", r -> r.path("/api/mots/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://PRESIDENT"))

                .route("semestres", r -> r.path("/api/semestres/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://SEMESTRE"))

                .route("slides", r -> r.path("/api/slides/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://SLIDES"))

                .route("anneesUniv", r -> r.path("/api/anneesUniv/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://UNIVESITAIRE"))

                .route("chapitres", r -> r.path("/api/chapitres/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURSENLIGNE"))

                .route("lecons", r -> r.path("/api/lecons/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURSENLIGNE"))

                .route("ressources", r -> r.path("/api/ressources/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURSENLIGNE"))

                .route("videos", r -> r.path("/api/videos/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURSENLIGNE"))

                .route("contacts", r -> r.path("/api/contacts/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://CONTACT"))

                .build();
    }
}
