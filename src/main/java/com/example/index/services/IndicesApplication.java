package com.example.index.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import brave.sampler.Sampler;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@SpringBootApplication
@EnableEurekaClient 
@EnableFeignClients
@CircuitBreaker(name = "BACKEND", fallbackMethod = "participantsClientFallback")
@RateLimiter(name = "BACKEND")
@Bulkhead(name = "BACKEND")
@Retry(name = "BACKEND", fallbackMethod = "participantsClientFallback")
@TimeLimiter(name = "BACKEND")
public class IndicesApplication {

	@Bean
	public IndexTradeInfoClientFallback participantsClientFallback() {
		return new IndexTradeInfoClientFallback();
	}

	@Bean
	@ConditionalOnProperty(name="indexService.rest.enabled", havingValue = "false", matchIfMissing = true)
	public IndexTradeInfoService feignParticipantsService() {
		return new FeignIndexTradeInfoService();
	}

	@Bean
	@ConditionalOnProperty(name="indexService.rest.enabled", havingValue = "true", matchIfMissing = false)
	public IndexTradeInfoService restParticipantsService() {
		return new RestIndexTradeInfoService();
	}

	@Bean
	public IndexService racesService(IndexTradeInfoService participantsService) {
		return new DefaultIndexService(participantsService);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemple() {
		return new RestTemplate();
	}

    public static void main(String[] args) {
        SpringApplication.run(IndicesApplication.class, args);
    }
}

@Component
@Profile("!test")
class ProdSampler {
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
