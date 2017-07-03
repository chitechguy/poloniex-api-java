package com.cf.data.model.poloniex;

import com.google.gson.Gson;

import java.math.BigDecimal;

/**
 *
 * @author David
 */
public class PoloniexChartData
{
    public final long date;
    public final double high;
    public final double low;
    public final double open;
    public final double close;
    public final BigDecimal volume;
    public final BigDecimal quoteVolume;
    public final double weightedAverage;

    public PoloniexChartData(long date, double high, double low, double open, double close, BigDecimal volume,
                             BigDecimal quoteVolume, double weightedAverage)
    {
        this.date = date;
        this.high = high;
        this.low = low;
        this.open = open;
        this.close = close;
        this.volume = volume;
        this.quoteVolume = quoteVolume;
        this.weightedAverage = weightedAverage;
    }

    @Override
    public String toString()
    {
        return new Gson().toJson(this);
    }
}
