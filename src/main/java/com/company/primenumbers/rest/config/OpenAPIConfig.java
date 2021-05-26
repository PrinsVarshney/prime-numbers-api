package com.company.primenumbers.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion,
    		@Value("${springdoc.title}") String appTitle,
    		@Value("${springdoc.description}") String appDescription,
    		@Value("${springdoc.contact.name}") String contactName,
    		@Value("${springdoc.contact.url}") String contactURL) {
    	
    	log.debug("CustomOpenAPI Version : {}", appVersion);
        
    	return new OpenAPI()
                .info(new Info().title(appTitle)
                .version(appVersion)
                .contact(new Contact().name(contactName)
                         .url(contactURL))
                .description(appDescription));
    }
    
}