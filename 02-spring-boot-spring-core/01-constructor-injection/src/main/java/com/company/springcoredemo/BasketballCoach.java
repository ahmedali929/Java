package com.company.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Practice shooting for 15 minutes!!!";
    }
}
