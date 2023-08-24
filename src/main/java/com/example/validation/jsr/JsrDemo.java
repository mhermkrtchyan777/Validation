package com.example.validation.jsr;

import com.example.validation.jsr.config.AppConfig;
import com.example.validation.jsr.obj.Singer;
import com.example.validation.jsr.service.SingerValidationService;
import jakarta.validation.ConstraintViolation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Set;

public class JsrDemo {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingerValidationService service = ctx.getBean(SingerValidationService.class);

        Singer singer = new Singer();
        singer.setFirstName("J");
        singer.setLastName("Mayer");
        singer.setGenre(null);
        singer.setGender(null);

        validateSinger(singer, service);
        ctx.close();
    }

    private static void validateSinger(Singer singer, SingerValidationService singerValidationService) {
        Set<ConstraintViolation<Singer>> violations = singerValidationService.validateSinger(singer);
        listViolations(violations);
    }

    private static void listViolations(Set<ConstraintViolation<Singer>> violations) {
        System.out.println("No of violations: " + violations.size());
        for (var violation : violations) {
            System.out.println("Validation error for property: " +
                               violation.getPropertyPath()
                               + " with value: " + violation.getInvalidValue()
                               + " with error message: " + violation.getMessage());
        }
    }
}
