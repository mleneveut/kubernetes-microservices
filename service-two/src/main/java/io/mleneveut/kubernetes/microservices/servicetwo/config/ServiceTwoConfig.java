package io.mleneveut.kubernetes.microservices.servicetwo.config;

import io.mleneveut.kubernetes.microservices.servicetwo.settings.ServiceTwoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * Service Two configuration.
 */
@Configuration
@EnableConfigurationProperties({ ServiceTwoSettings.class})
@EnableCircuitBreaker
@EnableDiscoveryClient
public class ServiceTwoConfig {


    @Autowired
    private ServiceTwoSettings settings;


    /**
     * RestTemplate to call another microservice with an HTTP REST call.
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

