package com.ecpi.youtube.parser;

import com.ecpi.youtube.model.ChannelInfo;
import com.ecpi.youtube.model.CountryChannelTotal;
import com.ecpi.youtube.model.JustCountry;
import com.ecpi.youtube.util.YtChannelAbout;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractYtBulkParser implements IYtBulkParser{
    protected final static int MAX_THREADS = 10;
    protected final static int MIN_THREADS = 2;
    private static final Logger logger = Logger.getLogger(AbstractYtBulkParser.class);

    protected int checkThreadsCount(int threadCount) {
        if (threadCount > MAX_THREADS) {
            logger.warn("More than max threads! Set to " + MAX_THREADS);
            threadCount = MAX_THREADS;
        }
        if (threadCount < MIN_THREADS) {
            logger.warn("Less than min threads! Set to " + MIN_THREADS);
            threadCount = MIN_THREADS;
        }
        return threadCount;
    }

    public abstract void prepareResolver();

    public abstract Collection<CountryChannelTotal> parallelParse(List<YtChannelAbout> channelAbouts, int threadCount);

    public abstract Collection<CountryChannelTotal> parse(List<YtChannelAbout> channelAbouts);

    protected Map<JustCountry, CountryChannelTotal> transform(List<ChannelInfo> channelInfos) {
        Map<JustCountry, CountryChannelTotal> countryChannelTotals = new HashMap<>();
        channelInfos.forEach(channelInfo -> {
            CountryChannelTotal channelTotal;
            if (countryChannelTotals.containsKey(channelInfo.getCountry())) {
                channelTotal = countryChannelTotals.get(channelInfo.getCountry());
            } else {
                channelTotal = new CountryChannelTotal();
                channelTotal.setJustCountry(channelInfo.getCountry());
                countryChannelTotals.put(channelInfo.getCountry(), channelTotal);
            }
            channelTotal.plusSubscribers(channelInfo.getSubscribers());
            channelTotal.incrementChannels();
            channelTotal.plusViews(channelInfo.getViews());
        });
        return countryChannelTotals;
    }

}
