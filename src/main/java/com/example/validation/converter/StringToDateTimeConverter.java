package com.example.validation.converter;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;


@Getter
public class StringToDateTimeConverter implements Converter<String, DateTime> {
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private DateTimeFormatter dateFormat;
    private String datePattern = DEFAULT_DATE_PATTERN;

    @PostConstruct
    public void init() {
        dateFormat = DateTimeFormat.forPattern(datePattern);
    }

    @Override
    public DateTime convert(String dateString) {
        return dateFormat.parseDateTime(dateString);
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}
