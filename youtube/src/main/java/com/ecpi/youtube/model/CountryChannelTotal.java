package com.ecpi.youtube.model;

public class CountryChannelTotal implements Comparable<CountryChannelTotal> {
    private JustCountry justCountry;
    private Long subscribersTotal = 0L;
    private Long channelsTotal = 0L;

    public JustCountry getJustCountry() {
        return justCountry;
    }

    public void setJustCountry(JustCountry justCountry) {
        this.justCountry = justCountry;
    }

    public Long getSubscribersTotal() {
        return subscribersTotal;
    }

    public void setSubscribersTotal(Long subscribersTotal) {
        this.subscribersTotal = subscribersTotal;
    }

    public Long getChannelsTotal() {
        return channelsTotal;
    }

    public void setChannelsTotal(Long channelsTotal) {
        this.channelsTotal = channelsTotal;
    }

    public void incrementChannels() {
        channelsTotal++;
    }

    public void plusSubscribers(long subscribers) {
        subscribersTotal += subscribers;
    }

    @Override
    public int compareTo(CountryChannelTotal o) {
        return o.subscribersTotal.compareTo(this.subscribersTotal);
    }
}
