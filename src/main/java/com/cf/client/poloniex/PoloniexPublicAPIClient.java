package com.cf.client.poloniex;

import com.cf.PriceDataAPIClient;
import com.cf.client.HTTPClient;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;

/**
 * @author David
 */
public class PoloniexPublicAPIClient implements PriceDataAPIClient {

	private static final String PUBLIC_URL = "https://api.poloniex.com/public?";
	private final HTTPClient client;

	public PoloniexPublicAPIClient() {
		this.client = new HTTPClient();
	}

	public PoloniexPublicAPIClient(HTTPClient client) {
		this.client = client;
	}

	@Override
	public String returnTicker() {
		try {
			String url = PUBLIC_URL + "command=returnTicker";
			return client.getHttp(url, null);
		} catch (IOException ex) {
			if (LogManager.getLogger().getLevel().isLessSpecificThan(Level.DEBUG)) {
				LogManager.getLogger(PoloniexPublicAPIClient.class).debug("Call to return ticker API resulted in exception - " + ex.getMessage(), ex);
			} else {
				LogManager.getLogger(PoloniexPublicAPIClient.class).warn("Call to return ticker API resulted in exception - " + ex.getMessage());
			}
		}

		return null;
	}

	@Override
	public String returnOrderBook(String currencyPair) {
		try {
			String url = PUBLIC_URL + "command=returnOrderBook&currencyPair=" + currencyPair;
			return client.getHttp(url, null);
		} catch (IOException ex) {
			if (LogManager.getLogger().getLevel().isLessSpecificThan(Level.DEBUG)) {
				LogManager.getLogger(PoloniexPublicAPIClient.class).debug("Call to return order book API resulted in exception - " + ex.getMessage(), ex);
			} else {
				LogManager.getLogger(PoloniexPublicAPIClient.class).warn("Call to return order book API resulted in exception - " + ex.getMessage());
			}
		}

		return null;
	}

	@Override
	public String return24Volume() {
		try {
			String url = PUBLIC_URL + "command=return24Volume";
			return client.getHttp(url, null);
		} catch (IOException ex) {
			if (LogManager.getLogger().getLevel().isLessSpecificThan(Level.DEBUG)) {
				LogManager.getLogger(PoloniexPublicAPIClient.class).debug("Call to return 24 volume API resulted in exception - " + ex.getMessage(), ex);
			} else {
				LogManager.getLogger(PoloniexPublicAPIClient.class).warn("Call to return 24 volume API resulted in exception - " + ex.getMessage());
			}
		}

		return null;
	}

	@Override
	public String returnTradeHistory(String currencyPair, Long startEpochSeconds, Long endEpochSeconds){
		try {
			String url = PUBLIC_URL + "command=returnTradeHistory&currencyPair=" + currencyPair + "&start=" + startEpochSeconds + "&end=" + endEpochSeconds;
			return client.getHttp(url, null);
		} catch (IOException ex) {
			if (LogManager.getLogger().getLevel().isLessSpecificThan(Level.DEBUG)) {
				LogManager.getLogger(PoloniexPublicAPIClient.class).debug("Call to return 24 volume API resulted in exception - " + ex.getMessage(), ex);
			} else {
				LogManager.getLogger(PoloniexPublicAPIClient.class).warn("Call to return 24 volume API resulted in exception - " + ex.getMessage());
			}
		}

		return null;
	}

	@Override
	public String returnTradeHistory(String currencyPair){
		try {
			String url = PUBLIC_URL + "command=returnTradeHistory&currencyPair=" + currencyPair;
			return client.getHttp(url, null);
		} catch (IOException ex) {
			if (LogManager.getLogger().getLevel().isLessSpecificThan(Level.DEBUG)) {
				LogManager.getLogger(PoloniexPublicAPIClient.class).debug("Call to return 24 volume API resulted in exception - " + ex.getMessage(), ex);
			} else {
				LogManager.getLogger(PoloniexPublicAPIClient.class).warn("Call to return 24 volume API resulted in exception - " + ex.getMessage());
			}
		}

		return null;
	}
	@Override
	public String getUSDBTCChartData(Long periodInSeconds, Long startEpochInSeconds) {
		String currencyPair = "USDT_BTC";
		return getChartData(currencyPair, periodInSeconds, startEpochInSeconds);
	}

	@Override
	public String getUSDETHChartData(Long periodInSeconds, Long startEpochInSeconds) {
		String currencyPair = "USDT_ETH";
		return getChartData(currencyPair, periodInSeconds, startEpochInSeconds);
	}

	@Override
	public String getChartData(String currencyPair, Long periodInSeconds, Long startEpochSeconds) {
		return getChartData(currencyPair, periodInSeconds, startEpochSeconds, 9999999999L);
	}

	@Override
	public String getChartData(String currencyPair, Long periodInSeconds, Long startEpochSeconds, Long endEpochSeconds) {
		return getChartData(currencyPair, startEpochSeconds.toString(), endEpochSeconds.toString(), periodInSeconds.toString());
	}

	private String getChartData(String currencyPair, String startEpochInSec, String endEpochInSec, String periodInSec) {
		try {
			String url = PUBLIC_URL + "command=returnChartData&currencyPair=" + currencyPair + "&start=" + startEpochInSec + "&end=" + endEpochInSec + "&period=" + periodInSec;
			return client.getHttp(url, null);
		} catch (IOException ex) {
			if (LogManager.getLogger().getLevel().isLessSpecificThan(Level.DEBUG)) {
				LogManager.getLogger(PoloniexPublicAPIClient.class).debug("Call to Chart Data API resulted in exception - " + ex.getMessage(), ex);
			} else {
				LogManager.getLogger(PoloniexPublicAPIClient.class).warn("Call to Chart Data API resulted in exception - " + ex.getMessage());
			}
		}

		return null;
	}

}
