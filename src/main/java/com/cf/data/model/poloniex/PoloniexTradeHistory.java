package com.cf.data.model.poloniex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

/**
 * @author David
 */
public class PoloniexTradeHistory {

	public final Long globalTradeID;
	public final String tradeID;
	public final LocalDateTime date;
	public final String rate;
	public final String amount;
	public final String total;
	public final String fee;
	public final String orderNumber;
	public final String type;
	public final String category;

	public PoloniexTradeHistory(Long globalTradeID, String tradeID, LocalDateTime date, String rate,
	                            String amount, String total, String fee,
	                            String orderNumber, String type, String category) {
		this.globalTradeID = globalTradeID;
		this.tradeID = tradeID;
		this.date = date;
		this.rate = rate;
		this.amount = amount;
		this.total = total;
		this.fee = fee;
		this.orderNumber = orderNumber;
		this.type = type;
		this.category = category;
	}

	@Override
	public String toString() {
		return getGson().toJson(this);
	}

	private Gson getGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());

		return gsonBuilder.create();
	}
}
