package com.example.CRUD.Fullstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Путь, который нужно разрешить
                .allowedOrigins("http://localhost:3000") // Разрешенный источник
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Разрешенные HTTP-методы
                .allowCredentials(true); // Разрешить передачу куки и заголовков авторизации
    }
}
