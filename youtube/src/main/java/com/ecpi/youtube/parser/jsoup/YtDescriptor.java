package com.ecpi.youtube.parser.jsoup;

import com.ecpi.youtube.ex.YoutubeDefaultException;
import com.ecpi.youtube.model.ChannelInfo;
import com.ecpi.youtube.parser.ValueObject;
import com.ecpi.youtube.util.YtChannelAbout;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class YtDescriptor {
    private static final Logger logger = Logger.getLogger(YtDescriptor.class);
    private final YtChannelAbout ytChannel;

    public YtDescriptor(YtChannelAbout ytCh) {
        this.ytChannel = ytCh;
    }

    public ChannelInfo resolve() throws YoutubeDefaultException {
        Document doc = null;
        try {
            doc = Jsoup.connect(ytChannel.getAboutURL()).get();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new YoutubeDefaultException(e);
        }
        //Elements elements = doc.getElementsByClass("country-inline");
        logger.debug("Parsing doc: " + doc.title());
        ValueObject<String> country = PageResolver.resolveCountry(doc);
        ValueObject<Long> subscribers = PageResolver.resolveSubscribers(doc);
        ValueObject<Long> views = PageResolver.resolveViews(doc);

        ChannelInfo channelInfo = new ChannelInfo() {{
            setChannelID(ytChannel.getChannelId());
            setCountry(country.getValue());
            setSubscribers(subscribers.getValue());
            setViews(views.getValue());
        }};
        return channelInfo;

    }
}
