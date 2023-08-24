package com.example.validation.formatting;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Component("conversionService")
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private DateTimeFormatter dateFormat;
    @Getter
    private String datePattern = DEFAULT_DATE_PATTERN;
    private final Set<Formatter<?>> formatters = new HashSet<>();

    @Autowired(required = false)
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @PostConstruct
    public void init() {
        dateFormat = DateTimeFormat.forPattern(datePattern);
        formatters.add(getDateTimeFormatter());
        setFormatters(formatters);
    }

    public Formatter<DateTime> getDateTimeFormatter() {
        return new Formatter<>() {
            @Override
            public DateTime parse(String dateTimeString, Locale locale) throws ParseException {
                System.out.println("Parsing date string: " + dateTimeString);
                return dateFormat.parseDateTime(dateTimeString);
            }

            @Override
            public String print(DateTime dateTime, Locale locale) {
                System.out.println("Formatting datetime: " + dateTime);
                return dateFormat.print(dateTime);
            }
        };
    }
}
