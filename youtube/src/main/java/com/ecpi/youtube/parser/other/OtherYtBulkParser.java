package com.ecpi.youtube.parser.other;

import com.ecpi.youtube.model.CountryChannelTotal;
import com.ecpi.youtube.parser.AbstractYtBulkParser;
import com.ecpi.youtube.parser.IYtBulkParser;
import com.ecpi.youtube.util.YtChannelAbout;

import java.util.Collection;
import java.util.List;

public class OtherYtBulkParser extends AbstractYtBulkParser implements IYtBulkParser {
    @Override
    public void prepareResolver() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<CountryChannelTotal> parallelParse(List<YtChannelAbout> channelAbouts, int threadCount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<CountryChannelTotal> parse(List<YtChannelAbout> channelAbouts) {
        throw new UnsupportedOperationException();
    }
}
