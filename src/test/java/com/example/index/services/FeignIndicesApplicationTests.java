package com.example.index.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import com.example.index.services.FeignIndexTradeInfoService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner
@DirtiesContext
@ActiveProfiles("test")
public class FeignIndicesApplicationTests extends IndicesApplicationTestBase {

	@Test
	public void serviceTypeTest() {
		assertTrue(FeignIndexTradeInfoService.class.isInstance(indexTradeInfoService));
	}
}
