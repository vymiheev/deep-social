package com.ecpi.youtube.parser.jsoup;

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

    public void resolve() throws IOException {
        Document doc = Jsoup.connect(ytChannel.getAboutURL()).get();
        String title = doc.title();
        logger.debug(title);

    }
}
