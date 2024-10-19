package com.boutique.service;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {

    private final RestTemplate restTemplate;

    @Autowired
    public ExternalService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @CircuitBreaker(name = "citasService", fallbackMethod = "citasFallback")
    public String callClienteService() {
        String url = "http://localhost:8081/citas/sedes";
        return restTemplate.getForObject(url, String.class);
    }


    public String citasFallback(Throwable throwable) {
        System.out.println("Fallback activado debido a: " + throwable.getMessage());
        return null;
    }


}