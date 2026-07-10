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
                // AUTH (public)
                // =========================
                .route("auth", r -> r.path("/api/auth/**")
                        .uri("lb://UTILISATEUR"))

                // =========================
                // ADMIN SERVICE
                // =========================
                .route("admin", r -> r.path("/api/admin/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ADMIN"))

                .route("organigrammes", r -> r.path("/api/organigrammes/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ADMIN"))

                .route("notifications", r -> r.path("/api/notifications/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ADMIN"))

                .route("anneesUniv", r -> r.path("/api/anneesUniv/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ADMIN"))

                .route("mots", r -> r.path("/api/mots/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ADMIN"))

                .route("slides", r -> r.path("/api/slides/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ADMIN"))

                .route("encadrements", r -> r.path("/api/encadrements/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ADMIN"))

                .route("memoires", r -> r.path("/api/memoires/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ADMIN"))

                // =========================
                // ETUDIANT SERVICE
                // =========================
                .route("etudiants", r -> r.path("/api/etudiant", "/api/etudiant/**", "/api/etudiants", "/api/etudiants/**")
                        .filters(f -> f
                                .filter(filter.apply(new JwtAuthenticationFilter.Config()))
                                .rewritePath("/api/etudiant[s]?(?<segment>/?.*)", "/etudiants${segment}"))
                        .uri("lb://ETUDIANT"))

                .route("notes", r -> r.path("/api/notes/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ETUDIANT"))

                .route("moyennes", r -> r.path("/api/moyennes/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ETUDIANT"))

                .route("presences", r -> r.path("/api/presences/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ETUDIANT"))

                .route("historiques", r -> r.path("/api/historiques/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://ETUDIANT"))

                // =========================
                // ENSEIGNANT SERVICE
                // =========================
                .route("enseignants", r -> r.path("/api/enseignant", "/api/enseignant/**", "/api/enseignants", "/api/enseignants/**", "/api/Enseignants", "/api/Enseignants/**")
                        .filters(f -> f
                                .filter(filter.apply(new JwtAuthenticationFilter.Config()))
                                .rewritePath("/api/enseignant[s]?(?<segment>/?.*)", "/api/Enseignants${segment}"))
                        .uri("lb://ENSEIGNANT"))

                // =========================
                // COURS SERVICE
                // =========================
                .route("cours", r -> r.path("/api/cours/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURS"))

                .route("matieres", r -> r.path("/api/matieres/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURS"))

                .route("chapitres", r -> r.path("/api/chapitres/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURS"))

                .route("domains", r -> r.path("/api/domains/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURS"))

                .route("ressources", r -> r.path("/api/ressours/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURS"))

                .route("semestres", r -> r.path("/api/semestres/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURS"))

                .route("niveau", r -> r.path("/api/niveau/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURS"))

                .route("filiers", r -> r.path("/api/filiers", "/api/filiers/**", "/api/filieres", "/api/filieres/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://FILIERES"))

                .route("emploiDuTemps", r -> r.path("/api/emploiDuTemps/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://COURS"))

                .route("formationInitiale", r -> r.path("/api/formationInitiale/**")
                        .uri("lb://COURS"))

                .route("formationContinue", r -> r.path("/api/formationContinue/**")
                        .uri("lb://COURS"))

                .route("formationEnLigne", r -> r.path("/api/formationEnLigne", "/api/formationEnLigne/**")
                        .filters(f -> f.rewritePath("/api/formationEnLigne(?<segment>/?.*)", "/formation_enligne${segment}"))
                        .uri("http://localhost:8083"))

                // =========================
                // ACTUALITE SERVICE (public)
                // =========================
                .route("actualites", r -> r.path("/api/actualites/**")
                        .uri("lb://ACTUALITE"))

                .route("encadreurs", r -> r.path("/api/encadreurs/**")
                        .uri("lb://ENCADREURS"))

                .route("contacts", r -> r.path("/api/contacts/**")
                        .uri("lb://CONTACTS"))

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
