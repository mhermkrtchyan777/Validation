package com.example.validation.jsr.obj;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Singer {
    @NotNull
    @Size(min = 2,max = 60)
    private String firstName;

    private String lastName;

    @NotNull
    private Genre genre;

    @NotNull
    private Gender gender;
}
