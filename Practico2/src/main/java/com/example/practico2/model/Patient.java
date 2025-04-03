package com.example.practico2.model;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Patient {
    private String name;
    private String order;
    private List<TestResult> result;

    public Patient(){
        this.result = new ArrayList<>();
    }
}
