package com.example.index.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultIndexService implements IndexService {

	private final List<Index> indices = new ArrayList<>();
	private final IndexTradeInfoService indexTradeInfoService;

	
	public DefaultIndexService(IndexTradeInfoService indexTradeInfoService) {
		this.indexTradeInfoService = indexTradeInfoService;
		indices.add(new Index("Growth Index", "Index001", Arrays.asList("vod.l", "tsco.l"), new Date(), Math.random()*10000));
		indices.add(new Index("US Equity Future Index", "Index002", Arrays.asList("goog.us", "amzn.us"), new Date(), Math.random()*10000));
	}

	@Override
	public List<Index> getAllLiveIndices() {
		return indices;
	}

	@Override
	public List<IndexWithTradeInfo> getAllIndicesWithTradeInfo() {
		List<IndexWithTradeInfo> indexWithTradeInfoList = new ArrayList<IndexWithTradeInfo>();
		List<TradeInfo> tradeInfoList = indexTradeInfoService.getAllTradeInfo();
		for(Index index : indices) {
			indexWithTradeInfoList.add(new IndexWithTradeInfo(index, tradeInfoList.stream().filter(
					tradeInfo -> tradeInfo.getIndexId().equals(index.getId())).collect(Collectors.toList())));
		}
		return indexWithTradeInfoList;
	}
}
