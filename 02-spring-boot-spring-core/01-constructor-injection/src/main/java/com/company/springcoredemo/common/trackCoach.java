package com.company.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class trackCoach implements Coach{

    public trackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
