package com.example.index.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="index-service", fallback = IndexTradeInfoClientFallback.class)
public interface FeignIndexTradeInfoClient {
	@GetMapping(value="/index/{indexId}")
	List<TradeInfo> getIndexTradeInfoFeignClient(@PathVariable("indexId") String indexId);

	@GetMapping(value="/")
	List<TradeInfo> getAllIndexTradeInfoFeignClient();
}
class IndexTradeInfoClientFallback implements FeignIndexTradeInfoClient {
	@Override
	public List<TradeInfo> getIndexTradeInfoFeignClient(String indexId) {
		return new ArrayList<>();
	}

	@Override
	public List<TradeInfo> getAllIndexTradeInfoFeignClient() {
		return new ArrayList<>();
	}
}
