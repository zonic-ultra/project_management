package com.dendev.project_management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new  WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/api/**")
                            .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                            .allowedOrigins("http://localhost:3000/")
                            .allowedHeaders("*");
                }
        };
    }

}
