package com.patrinav.viewit.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrinav.viewit.controllers.MoviesController;
import com.patrinav.viewit.controllers.ProductsController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScans(value={
        @ComponentScan("com.patrinav.viewit.services")
})
public class WebConfig implements WebMvcConfigurer{

    @Bean
    public MoviesController moviesController() {
        return new MoviesController();
    }

    @Bean
    public ProductsController productsController() {
        return new ProductsController();
    }

    // To convert from JAVA to JSON, so we specify the converters we want it to use
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = new ObjectMapper();
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
    }
}
