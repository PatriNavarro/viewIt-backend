package com.patrinav.viewit.configuration;

import com.patrinav.viewit.controllers.MoviesController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig {

    @Bean
    public MoviesController moviesController() {
        return new MoviesController();
    }
}
