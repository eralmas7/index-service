package com.example.index.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.index.services.RestIndexTradeInfoService;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
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
