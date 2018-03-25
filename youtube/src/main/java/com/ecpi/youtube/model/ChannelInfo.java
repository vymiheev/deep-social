package com.ecpi.youtube.model;

import java.util.Objects;

public class ChannelInfo {
    private JustCountry country;
    private Long subscribers;
    private String channelID;
    private Long views;

    public JustCountry getCountry() {
        return country;
    }

    public void setCountry(JustCountry country) {
        this.country = country;
    }

    public void setCountry(String name) {
        this.country = new JustCountry(name);
    }

    public Long getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Long subscribers) {
        this.subscribers = subscribers;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChannelInfo that = (ChannelInfo) o;
        return Objects.equals(channelID, that.channelID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelID);
    }
}
