package com.ecpi.youtube.parser;

import org.apache.commons.lang3.StringUtils;

public class AbstractPageResolver {
    protected static final String UNDEFINED_STRING_VAL = "UNDEFINED";
    protected static final Long UNDEFINED_LONG_VAL = -1L;
    protected static final ValueObject<String> UNDEFINED_STRING_VO = new ValueObject<>(UNDEFINED_STRING_VAL);
    protected static final ValueObject<Long> UNDEFINED_LONG_VO = new ValueObject<>(UNDEFINED_LONG_VAL);

    protected static ValueObject<String> wrapVO(String value) {
        return new ValueObject<>(StringUtils.isEmpty(value) ? UNDEFINED_STRING_VAL : value);
    }

    protected static ValueObject<Long> wrapVO(Long views) {
        return new ValueObject<>(views == null ? UNDEFINED_LONG_VAL : views);
    }

    protected static Long parseNumber(String val) {
        return val == null ? null : Long.valueOf(val.replaceAll("\\D", ""));
    }
}
