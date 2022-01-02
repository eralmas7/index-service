package com.example.index.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RestIndexTradeInfoService implements IndexTradeInfoService {

	@Autowired
//	@LoadBalanced
	private RestTemplate rest;

	@Override
	public List<TradeInfo> getAllTradeInfo() {
		return Arrays.asList(rest.getForObject("http://trade-service", TradeInfo[].class));
	}

	@Override
	public List<TradeInfo> getTradeInfo(String indexId) {
		return Arrays.asList(rest.getForObject("http://trade-service/index/" + indexId, TradeInfo[].class));
	}

}
