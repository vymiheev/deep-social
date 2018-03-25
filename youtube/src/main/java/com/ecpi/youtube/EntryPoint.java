package com.ecpi.youtube;

import com.ecpi.youtube.parser.jsoup.YtBulkParser;
import com.ecpi.youtube.util.ResLoader;
import com.ecpi.youtube.util.YtChannelAbout;
import org.apache.log4j.Logger;

import java.util.List;

public class EntryPoint {
    private static final Logger logger = Logger.getLogger(EntryPoint.class);

    public static void main(String[] args) {
        List<String> lines;
        logger.debug("Read lines...");
        List<YtChannelAbout> channelAbouts = ResLoader.buildChannels("G:\\work\\projects\\deep-social\\yt-ch1.txt");
        //inject proper parser
        YtBulkParser jSoupParser = new YtBulkParser(channelAbouts);
        jSoupParser.parse();
        //jSoupParser.
    }
}
