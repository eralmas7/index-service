package com.example.index.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="index-service", fallback = IndexTradeInfoClientFallback.class)
public interface FeignIndexTradeInfoClient {
	@RequestMapping(method = RequestMethod.GET, value="/index/{indexId}")
	List<TradeInfo> getIndexTradeInfoFeignClient(@PathVariable("indexId") String indexId);

	@RequestMapping(method = RequestMethod.GET, value="/")
	List<TradeInfo> getAllIndexTradeInfoFeignClient();
}
class IndexTradeInfoClientFallback implements FeignIndexTradeInfoClient {
	@Override
	public List<TradeInfo> getIndexTradeInfoFeignClient(String indexId) {
		return new ArrayList<TradeInfo>();
	}

	@Override
	public List<TradeInfo> getAllIndexTradeInfoFeignClient() {
		return new ArrayList<TradeInfo>();
	}
}
