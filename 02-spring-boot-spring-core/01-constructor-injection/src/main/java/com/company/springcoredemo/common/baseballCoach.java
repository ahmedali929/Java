package com.company.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class baseballCoach implements Coach{

    public baseballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice";
    }

}
