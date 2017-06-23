package com.example.index.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;

public class IndicesApplicationTestBase {

	@Autowired
	protected IndexTradeInfoService indexTradeInfoService;

	private List<TradeInfo> tradeInfoList;


	//Hack to work around https://github.com/spring-cloud/spring-cloud-commons/issues/156
	static {
		System.setProperty("eureka.client.enabled", "false");
		System.setProperty("spring.cloud.config.failFast", "false");
	}

	@Before
	public void setup() {
		this.tradeInfoList = new ArrayList<>();
		tradeInfoList.add(new TradeInfo("Index001", "trade001", "desk001", 1000000, getDateAfter(52*7), getDateAfter(0), 18273.93));
		tradeInfoList.add(new TradeInfo("Index001", "trade002", "desk001", 5000000, getDateAfter(52*3), getDateAfter(-1), 11273.93));
		tradeInfoList.add(new TradeInfo("Index002", "trade003", "desk001", 75000000, getDateAfter(52*1), getDateAfter(0), 18273.93));
	}
	
	private static Date getDateAfter(int weeks) {
		return Date.from(LocalDate.now().plusYears(weeks).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	@After
	public void tearDown() {
		this.tradeInfoList = null;
	}

	@Test
	public void contextLoads() {
		List<TradeInfo> tradeInfoList = indexTradeInfoService.getAllTradeInfo();
		assertEquals(this.tradeInfoList, tradeInfoList);
	}

}
