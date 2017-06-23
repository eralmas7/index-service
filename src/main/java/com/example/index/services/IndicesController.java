package com.example.index.services;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndicesController {

	private IndexService indexService;

	public IndicesController(IndexService indexService) {
		this.indexService = indexService;
	}

	@RequestMapping("/")
	public List<Index> getLiveIndices() {
		return indexService.getAllLiveIndices();
	}

	@RequestMapping("/indices")
	public List<IndexWithTradeInfo> getIndicesWithTradeInfo() {
		return indexService.getAllIndicesWithTradeInfo();
	}

}
