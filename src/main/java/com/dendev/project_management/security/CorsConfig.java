package com.dendev.project_management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        //  Allow credentials (needed for JWT / auth headers)
        config.setAllowCredentials(true);

        //  Your frontend URL
        config.setAllowedOrigins(List.of(
                "https://project-management-dendev.vercel.app"
//                "http://localhost:3000"
        ));

        // Allow all common methods
        config.setAllowedMethods(List.of(
                "GET", "POST", "PUT", "DELETE", "PATCH"
        ));

        //  Allow all headers
        config.setAllowedHeaders(List.of("*"));

        // Optional (good for Authorization header)
        config.setExposedHeaders(List.of("Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}