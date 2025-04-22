package com.company.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class tennisCoach implements Coach{

    public tennisCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 20 minutes to practice backhand volley";
    }
}
