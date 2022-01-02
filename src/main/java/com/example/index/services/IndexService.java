package com.example.index.services;

import java.util.List;

public interface IndexService {

	public List<Index> getAllLiveIndices();

	public List<IndexWithTradeInfo> getAllIndicesWithTradeInfo();
	
	public List<String> getConstituents(String indexId);
}