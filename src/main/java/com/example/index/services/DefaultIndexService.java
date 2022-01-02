package com.example.index.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefaultIndexService implements IndexService {

	private final Map<String, Index> indices = new HashMap<>();
	private final IndexTradeInfoService indexTradeInfoService;

	
	public DefaultIndexService(IndexTradeInfoService indexTradeInfoService) {
		this.indexTradeInfoService = indexTradeInfoService;
		indices.put("Index001", new Index("Growth Index", "Index001", Arrays.asList("vod.l", "tsco.l"), new Date(), Math.random()*10000));
		indices.put("Index002", new Index("US Equity Future Index", "Index002", Arrays.asList("goog.us", "amzn.us"), new Date(), Math.random()*10000));
	}

	@Override
	public List<Index> getAllLiveIndices() {
		return new ArrayList<>(indices.values());
	}

	@Override
	public List<IndexWithTradeInfo> getAllIndicesWithTradeInfo() {
		List<IndexWithTradeInfo> indexWithTradeInfoList = new ArrayList<>();
		List<TradeInfo> tradeInfoList = indexTradeInfoService.getAllTradeInfo();
		for(Index index : indices.values()) {
			indexWithTradeInfoList.add(new IndexWithTradeInfo(index, tradeInfoList.stream().filter(
					tradeInfo -> tradeInfo.getIndexId().equals(index.getId())).collect(Collectors.toList())));
		}
		return indexWithTradeInfoList;
	}

  @Override
  public List<String> getConstituents(String indexId) {
    return indices.getOrDefault(indexId, new Index()).getConstituents();
  }
}
