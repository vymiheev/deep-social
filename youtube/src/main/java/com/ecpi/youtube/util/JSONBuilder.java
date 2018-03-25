package com.ecpi.youtube.util;

import com.ecpi.youtube.model.CountryChannelTotal;
import com.google.gson.Gson;

import java.util.Collection;

public class JSONBuilder {
    public static String toJson(Collection<CountryChannelTotal> channelInfos) {
        Gson gson = new Gson();
        return gson.toJson(channelInfos);
    }
}
