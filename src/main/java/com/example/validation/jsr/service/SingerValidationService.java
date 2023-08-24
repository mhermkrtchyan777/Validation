package com.example.validation.jsr.service;

import com.example.validation.jsr.obj.Singer;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.Validator;

import java.util.Set;

@Service("singerValidationService")
public class SingerValidationService {
    private final Validator validator;

    @Autowired
    public SingerValidationService(Validator validator) {
        this.validator = validator;
    }

    public Set<ConstraintViolation<Singer>>
    validateSinger(Singer singer) {
        return validator.validate(singer);
    }
}
