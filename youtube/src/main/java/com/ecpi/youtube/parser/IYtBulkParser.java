package com.ecpi.youtube.parser;

import com.ecpi.youtube.model.CountryChannelTotal;
import com.ecpi.youtube.util.YtChannelAbout;

import java.util.Collection;
import java.util.List;

public interface IYtBulkParser {
    Collection<CountryChannelTotal> parallelParse(List<YtChannelAbout> channelAbouts, int threadCount);

    Collection<CountryChannelTotal> parse(List<YtChannelAbout> channelAbouts);
}
