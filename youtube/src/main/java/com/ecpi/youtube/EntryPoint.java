package com.ecpi.youtube;

import com.ecpi.youtube.model.CountryChannelTotal;
import com.ecpi.youtube.parser.jsoup.YtBulkParser;
import com.ecpi.youtube.util.JSONBuilder;
import com.ecpi.youtube.util.ResLoader;
import com.ecpi.youtube.util.YtChannelAbout;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.List;

public class EntryPoint {
    private static final Logger logger = Logger.getLogger(EntryPoint.class);
    //inject proper parser
    private YtBulkParser jSoupParser = new YtBulkParser();

    public static void main(String[] args) {
       /* if (ArrayUtils.isEmpty(args)) {
            throw new ConfigurationRuntimeException("Empty params!");
        }
        if (args.length > 1) {
            throw new ConfigurationRuntimeException("Too much params!");
        }
        String filepath = args[0];*/
        new EntryPoint().launch("files/yt-ch.txt");
    }

    private void launch(String filepath) {
        logger.debug("Read lines...");
        List<YtChannelAbout> channelAbouts = ResLoader.buildChannels(filepath);

        Collection<CountryChannelTotal> channelInfos = jSoupParser.parallelParse(channelAbouts, 5);
        logger.info(JSONBuilder.toJson(channelInfos));
    }
}
