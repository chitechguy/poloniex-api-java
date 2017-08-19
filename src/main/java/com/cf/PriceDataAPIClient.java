package com.cf;

/**
 * @author David
 */
public interface PriceDataAPIClient {

	String returnTicker();

	String returnOrderBook(String currencyPair);

	String return24hVolume();

	String returnTradeHistory(String currencyPair, Long startEpochSeconds, Long endEpochSeconds);

	String returnTradeHistory(String currencyPair);

	String getUSDBTCChartData(Long periodInSeconds, Long startEpochInSeconds);

	String getUSDETHChartData(Long periodInSeconds, Long startEpochInSeconds);

	String getChartData(String currencyPair, Long periodInSeconds, Long startEpochSeconds);

	String getChartData(String currencyPair, Long periodInSeconds, Long startEpochSeconds, Long endEpochSeconds);

}
