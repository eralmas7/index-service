package com.example.index.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import com.example.index.services.RestIndexTradeInfoService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"indexService.rest.enabled=true"})
@AutoConfigureStubRunner
@DirtiesContext
@ActiveProfiles("test")
public class IndicesApplicationTest extends IndicesApplicationTestBase {
	@Test
	public void serviceTypeTest() {
		assertTrue(RestIndexTradeInfoService.class.isInstance(indexTradeInfoService));
	}
}
