package com.ecpi.youtube.parser.jsoup;

import com.ecpi.youtube.ex.YoutubeDefaultException;
import com.ecpi.youtube.model.ChannelInfo;
import com.ecpi.youtube.model.CountryChannelTotal;
import com.ecpi.youtube.model.JustCountry;
import com.ecpi.youtube.parser.AbstractYtBulkParser;
import com.ecpi.youtube.util.YtChannelAbout;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class YtBulkParser extends AbstractYtBulkParser {
    private static final Logger logger = Logger.getLogger(YtBulkParser.class);

    public YtBulkParser() {
        prepareResolver();
    }

    public void prepareResolver() {
        PageResolverConf.init();
    }

    public Collection<CountryChannelTotal> parallelParse(List<YtChannelAbout> channelAbouts, int threadCount) {
        List<ChannelInfo> channelInfos = new ArrayList<>(channelAbouts.size());
        threadCount = checkThreadsCount(threadCount);
        List<Callable<ChannelInfo>> callables = new ArrayList<>(channelAbouts.size());
        channelAbouts.forEach(ytCh -> {
            Callable<ChannelInfo> callable = constructCallable(ytCh, channelInfos);
            callables.add(callable);
        });
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        try {
            executorService.invokeAll(callables);
            logger.debug("All is Done");
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        } finally {
            executorService.shutdown();
        }
        Map<JustCountry, CountryChannelTotal> countryChannelTotals = transform(channelInfos);
        return new TreeSet<>(countryChannelTotals.values());
    }

    private Callable<ChannelInfo> constructCallable(YtChannelAbout ytCh, List<ChannelInfo> channelInfos) {
        return () -> {
            YtDescriptor ytDescriptor = new YtDescriptor(ytCh);
            try {
                ChannelInfo channelInfo = ytDescriptor.resolve();
                synchronized (this) {
                    channelInfos.add(channelInfo);
                }
                return channelInfo;
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                throw new YoutubeDefaultException(e);
            }
        };
    }

    public Collection<CountryChannelTotal> parse(List<YtChannelAbout> channelAbouts) {
        List<ChannelInfo> channelInfos = new ArrayList<>(channelAbouts.size());
        channelAbouts.forEach(ytCh -> {
                    YtDescriptor ytDescriptor = new YtDescriptor(ytCh);
                    try {
                        ChannelInfo channelInfo = ytDescriptor.resolve();
                        channelInfos.add(channelInfo);
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }
                }
        );
        Map<JustCountry, CountryChannelTotal> countryChannelTotals = transform(channelInfos);
        return new TreeSet<>(countryChannelTotals.values());
    }
}
