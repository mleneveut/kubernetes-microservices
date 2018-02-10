package io.mleneveut.kubernetes.microservices.serviceone.config;

import io.mleneveut.kubernetes.microservices.serviceone.settings.ServiceOneSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


import org.springframework.web.client.RestTemplate;
/**
 * Service One configuration.
 */
@Configuration
@EnableConfigurationProperties({ ServiceOneSettings.class})
@EnableCircuitBreaker
@EnableDiscoveryClient
public class ServiceOneConfig {


    @Autowired
    private ServiceOneSettings settings;


    /**
     * RestTemplate to call another microservice with an HTTP REST call.
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

