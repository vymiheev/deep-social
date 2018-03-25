package com.ecpi.youtube.parser.jsoup;

import com.ecpi.youtube.util.YtChannelAbout;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class YtBulkParser {
    private static final Logger logger = Logger.getLogger(YtBulkParser.class);
    private final List<YtChannelAbout> channelAbouts;

    public YtBulkParser(List<YtChannelAbout> channelAbouts) {
        this.channelAbouts = channelAbouts;
    }

    public void parallelParse() {

    }

    public void parse() {
        channelAbouts.forEach(ytCh -> {
                    YtDescriptor ytDescriptor = new YtDescriptor(ytCh);
                    try {
                        ytDescriptor.resolve();
                    } catch (IOException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
        );

    }
}
