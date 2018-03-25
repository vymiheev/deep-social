package com.ecpi.youtube.util;

import com.ecpi.youtube.ex.ConfigurationRuntimeException;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ResLoader {
    private static final Logger logger = Logger.getLogger(ResLoader.class);

    public static List<YtChannelAbout> buildChannels(String txt) {
        List<String> channelIds = readAll(txt);
        List<YtChannelAbout> channelAbouts = new ArrayList<>();
        channelIds.stream().forEach(s -> {
            YtChannelAbout.ReplcaingBuilder replacingBuilder = YtChannelAbout.newReplacingBuilder();
            channelAbouts.add(replacingBuilder.setChannelId(s).build());
        });
        return channelAbouts;
    }

    public static List<String> readAll(String txt) {
        File file = new File(txt);
        try {
            return Files.readAllLines(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new ConfigurationRuntimeException(e);
        }
    }

}
