package com.example.index.services;


import java.util.Date;
import java.util.List;

public interface IndexTradeInfoService {

	public List<TradeInfo> getAllTradeInfo();

	public List<TradeInfo> getTradeInfo(String indexId);
}

class TradeInfo {
	private String indexId;
	private String tradeId;
	private String deskId;
	private double notional;
	private Date expiry;
	private Date tradeDate;
	private double level;
	
	public TradeInfo(){}

	public TradeInfo(String indexId, String tradeId, String deskId, double notional, Date expiry, Date tradeDate,
			double level) {
		this.indexId = indexId;
		this.tradeId = tradeId;
		this.deskId = deskId;
		this.notional = notional;
		this.expiry = expiry;
		this.tradeDate = tradeDate;
		this.level = level;
	}

	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getDeskId() {
		return deskId;
	}

	public void setDeskId(String deskId) {
		this.deskId = deskId;
	}

	public double getNotional() {
		return notional;
	}

	public void setNotional(double notional) {
		this.notional = notional;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((indexId == null) ? 0 : indexId.hashCode());
		result = prime * result + ((tradeId == null) ? 0 : tradeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeInfo other = (TradeInfo) obj;
		if (indexId == null) {
			if (other.indexId != null)
				return false;
		} else if (!indexId.equals(other.indexId))
			return false;
		if (tradeId == null) {
			if (other.tradeId != null)
				return false;
		} else if (!tradeId.equals(other.tradeId))
			return false;
		return true;
	}

	
}