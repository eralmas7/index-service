package com.example.index.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.index.services.FeignIndexTradeInfoService;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
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
