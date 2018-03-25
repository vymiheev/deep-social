package com.ecpi.youtube.parser.jsoup;

import com.ecpi.youtube.parser.AbstractPageResolver;
import com.ecpi.youtube.parser.ValueObject;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import static com.ecpi.youtube.parser.jsoup.PageResolverConf.*;

public class PageResolver extends AbstractPageResolver {
    private static final Logger logger = Logger.getLogger(PageResolver.class);

    public static ValueObject<String> resolveCountry(Document doc) {
        //Elements elements = doc.getElementsByClass("country-inline");
        SearchPattern searchPattern = find(COUNTRY_PATTERN);
        assert searchPattern != null;
        try {
            String countryVal = selectFirstRow(doc, searchPattern);
            return wrapVO(countryVal);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return UNDEFINED_STRING_VO;
        }
    }

    public static ValueObject<Long> resolveSubscribers(Document doc) {
        SearchPattern searchPattern = find(SUBSCRIBERS_STATS_PATTERN);
        assert searchPattern != null;
        try {
            String subscribersVal = selectFirstRow(doc, searchPattern);
            Long val = parseNumber(subscribersVal);
            return wrapVO(val);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return UNDEFINED_LONG_VO;
        }
    }

    public static ValueObject<Long> resolveViews(Document doc) {
        SearchPattern searchPattern = find(VIEWS_STATS_PATTERN);
        assert searchPattern != null;
        try {
            String viewsVal = selectFirstRow(doc, searchPattern);
            Long views = parseNumber(viewsVal);
            return wrapVO(views);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return UNDEFINED_LONG_VO;
        }
    }

    private static String selectFirstRow(Document doc, SearchPattern searchPattern) {
        Elements els = doc.select(searchPattern.getLine());
        String elVal = null;
        if (els.first() != null) {
            elVal = els.first().text();
        }
        return elVal;
    }
}
