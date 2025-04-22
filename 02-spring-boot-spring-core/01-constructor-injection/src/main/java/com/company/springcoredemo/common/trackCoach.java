package com.company.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class trackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
