package com.example.validation.formatting;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.convert.ConversionService;

public class ConvFormatServDemo {
    public static void main(String[] args) {
        GenericApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        Singer john=ctx.getBean(Singer.class);
        System.out.println(john);

        ConversionService conversionService=ctx.getBean("conversionService",ConversionService.class);
        System.out.println("Birthday of singer is : "+conversionService.convert(john.getBirthDate(), String.class));
    }
}
