package com.company.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Practice shooting for 15 minutes!!!";
    }
}
