package com.example.index.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.example.index.services.DefaultIndexService;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class DefaultIndexServiceTest {

	@Mock
	private IndexTradeInfoService indexTradeInfoService;
	private List<Index> indices;
	private List<IndexWithTradeInfo> indexWithTradeInfoList;
	private List<TradeInfo> tradeInfoList;

	@Before
	public void setup() {
		this.indices = new ArrayList<>();
		this.indexWithTradeInfoList = new ArrayList<>();
		this.tradeInfoList = new ArrayList<>();
		Index growthIndex = new Index("Growth Index", "Index001", Arrays.asList("vod.l", "tsco.l"), new Date(), Math.random()*10000);
		Index futureIndex = new Index("US Equity Future Index", "Index002", Arrays.asList("goog.us", "amzn.us"), new Date(), Math.random()*10000);
		TradeInfo firstTrade = new TradeInfo("Index001", "trade001", "desk001", 1000000, getDateAfter(52*7), getDateAfter(0), 18273.93);
		TradeInfo secondTrade = new TradeInfo("Index001", "trade002", "desk001", 5000000, getDateAfter(52*3), getDateAfter(-1), 11273.93);
		TradeInfo thirdTrade = new TradeInfo("Index002", "trade003", "desk001", 75000000, getDateAfter(52*1), getDateAfter(0), 18273.93);
		this.indices.add(growthIndex);
		this.indices.add(futureIndex);
		this.tradeInfoList.add(firstTrade);
		this.tradeInfoList.add(secondTrade);
		this.tradeInfoList.add(thirdTrade);
		this.indexWithTradeInfoList.add(new IndexWithTradeInfo(growthIndex, Arrays.asList(firstTrade, secondTrade)));
		this.indexWithTradeInfoList.add(new IndexWithTradeInfo(futureIndex, Arrays.asList(thirdTrade)));
	}

	private static Date getDateAfter(int weeks) {
		return Date.from(LocalDate.now().plusYears(weeks).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	@Test
	public void getAllIndicesTest() {
		DefaultIndexService defaultIndexService = new DefaultIndexService(indexTradeInfoService);
		assertEquals(indices, defaultIndexService.getAllLiveIndices());
	}

	@Test
	public void getAllIndicesWithTradeInfoTest() {
		doReturn(tradeInfoList).when(indexTradeInfoService).getAllTradeInfo();
		DefaultIndexService defaultIndexService = new DefaultIndexService(indexTradeInfoService);
		assertEquals(indexWithTradeInfoList, defaultIndexService.getAllIndicesWithTradeInfo());
	}
}
