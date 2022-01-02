package com.example.index.services;

import java.util.List;

public class IndexWithTradeInfo extends Index {
  private List<TradeInfo> tradeInfoList;

  public IndexWithTradeInfo(Index index,
          List<TradeInfo> tradeInfoList) {
      super(index.getName(), index.getId(), index.getConstituents(), index.getInceptionDate(), index.getIndexLevel());
      this.tradeInfoList = tradeInfoList;
  }

  public List<TradeInfo> getTradeInfoList() {
      return tradeInfoList;
  }

  public void setTradeInfoList(List<TradeInfo> tradeInfoList) {
      this.tradeInfoList = tradeInfoList;
  }

}