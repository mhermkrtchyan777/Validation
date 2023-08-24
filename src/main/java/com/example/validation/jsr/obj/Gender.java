package com.example.validation.jsr.obj;

public enum Gender {
    MALE("M"),FEMALE("F");
    private final String code;

    Gender(String code){
        this.code=code;
    }
    @Override
    public String toString(){
        return this.code;
    }
}
