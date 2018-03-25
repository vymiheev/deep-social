package com.ecpi.youtube.util;

import org.apache.commons.lang3.StringUtils;

public class YtChannelAbout {
    private String channelId;
    private String aboutURL;

    public static ReplacingBuilder newReplacingBuilder() {
        return new YtChannelAbout().new ReplacingBuilder();
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getAboutURL() {
        return aboutURL;
    }

    public void setAboutURL(String aboutURL) {
        this.aboutURL = aboutURL;
    }

    class ReplacingBuilder {

        private final String channelAboutURLPattern = "https://www.youtube.com/channel/%s/about";

        private ReplacingBuilder() {
        }

        public ReplacingBuilder setChannelId(String channelId) {
            YtChannelAbout.this.setChannelId(channelId);
            return this;
        }

        public YtChannelAbout build() {
            if (StringUtils.isEmpty(aboutURL)) {
                String aboutURL = String.format(channelAboutURLPattern, YtChannelAbout.this.getChannelId());
                YtChannelAbout.this.setAboutURL(aboutURL);
            }
            return YtChannelAbout.this;
        }
    }
}
