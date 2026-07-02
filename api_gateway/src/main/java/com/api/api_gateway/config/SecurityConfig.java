package com.api.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .cors(cors -> {})
                .authorizeExchange(exchanges -> exchanges

                        // public endpoints
                        .pathMatchers("/auth/**").permitAll()

                        // roles
                        .pathMatchers("/api/admin/**").hasRole("ADMIN")
                        .pathMatchers("/api/etudiant/**").hasRole("ETUDIANT")
                        .pathMatchers("/api/enseignant/**").hasRole("ENSEIGNANT")

                        .pathMatchers("/api/actualites/**").permitAll()

                        // others
                        .anyExchange().authenticated()
                )
                .build();
    }
}
