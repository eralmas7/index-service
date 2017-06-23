package com.example.index.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient 
@EnableFeignClients
@EnableCircuitBreaker
public class IndicesApplication {

	@Bean
	public IndexTradeInfoClientFallback ParticipantsClientFallback() {
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
class Sampler {
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}
