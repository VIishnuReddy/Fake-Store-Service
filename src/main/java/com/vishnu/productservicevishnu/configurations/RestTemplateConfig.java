package com.vishnu.productservicevishnu.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//Defining RestTemplate as a bean in the configuration class allows it to be managed as a singleton,
// meaning a single instance of RestTemplate will be created and shared across the application

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
