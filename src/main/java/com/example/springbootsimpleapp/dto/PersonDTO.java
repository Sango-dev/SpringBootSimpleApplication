package com.example.springbootsimpleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {
    private String firstName;
    private String lastName;
    private int age;
}
