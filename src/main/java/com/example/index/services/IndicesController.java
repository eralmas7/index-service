package com.example.index.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndicesController {

	private IndexService indexService;

	public IndicesController(IndexService indexService) {
		this.indexService = indexService;
	}

	@GetMapping("/")
	public List<Index> getLiveIndices() {
		return indexService.getAllLiveIndices();
	}

	@GetMapping("/indices")
	public List<IndexWithTradeInfo> getIndicesWithTradeInfo() {
		return indexService.getAllIndicesWithTradeInfo();
	}

}
