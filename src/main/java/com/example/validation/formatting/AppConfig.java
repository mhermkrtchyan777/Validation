package com.example.validation.formatting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
@ComponentScan(basePackages = "com.example.validation.formatting")
public class AppConfig {
    final
    ApplicationConversionServiceFactoryBean conversionService;

    @Autowired
    public AppConfig(ApplicationConversionServiceFactoryBean conversionService) {
        this.conversionService = conversionService;
    }

    @Bean
    public Singer john() throws Exception {
        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(conversionService.getDateTimeFormatter().parse("1977-10-16", Locale.ENGLISH));
        return singer;
    }
}
