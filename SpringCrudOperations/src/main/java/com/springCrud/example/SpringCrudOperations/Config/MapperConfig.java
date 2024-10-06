package com.springCrud.example.SpringCrudOperations.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

//vvvvvvv
    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }
}