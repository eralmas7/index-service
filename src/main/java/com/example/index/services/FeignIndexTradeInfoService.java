package com.example.index.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class FeignIndexTradeInfoService implements IndexTradeInfoService {

	private FeignIndexTradeInfoClient indexTradeInfoClient;

	@Autowired
	public void setIndexTradeInfoService(FeignIndexTradeInfoClient indexTradeInfoClient) {
		this.indexTradeInfoClient = indexTradeInfoClient;
	}

	@Override
	public List<TradeInfo> getAllTradeInfo() {
		return indexTradeInfoClient.getAllIndexTradeInfoFeignClient();
	}

	@Override
	public List<TradeInfo> getTradeInfo(String indexId) {
		return indexTradeInfoClient.getIndexTradeInfoFeignClient(indexId);
	}

	
	
}
