package com.ecpi.youtube.parser.jsoup;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PageResolverConf {
    public static final String COUNTRY_PATTERN = "COUNTRY_CSS_PATTERN";
    public static final String STATS_PATTERN = "STATS_CSS_PATTERN";
    public static final String SUBSCRIBERS_STATS_PATTERN = "SUBSCRIBERS_STATS_CSS_PATTERN";
    public static final String VIEWS_STATS_PATTERN = "VIEWS_STATS_CSS_PATTERN";
    private static Map<String, SearchPattern> patternMap = new ConcurrentHashMap<>();

    public static void addPattern(SearchPattern pattern) {
        patternMap.put(pattern.getName(), pattern);
    }

    public static SearchPattern find(String name) {
        return patternMap.get(name);
    }

    public static void init() {
        //possible this config will be fetched from DB
        addPattern(new SearchPattern(COUNTRY_PATTERN, "div.about-metadata-container > div.country-container > span.country-inline"));
        String statsPat = "div.about-metadata-container > div.about-metadata-stats > div.about-stats > .about-stat";
        addPattern(new SearchPattern(STATS_PATTERN, statsPat));
        addPattern(new SearchPattern(SUBSCRIBERS_STATS_PATTERN, statsPat + ":eq(0)"));
        addPattern(new SearchPattern(VIEWS_STATS_PATTERN, statsPat + ":eq(1)"));
    }
}
