package com.ecpi.youtube.util;

import com.ecpi.youtube.model.CountryChannelTotal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collection;

public class JSONBuilder {
    public static String toJson(Collection<CountryChannelTotal> channelInfos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(channelInfos);
    }
}
