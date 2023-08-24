package com.example.validation.jsr.obj;

public enum Genre {
    POP("P"),
    JAZZ("J"),
    BLUES("B"),
    COUNTRY("C");
    private final String code;
    Genre(String code){
        this.code=code;
    }
    @Override
    public String toString(){
        return this.code;
    }
}
