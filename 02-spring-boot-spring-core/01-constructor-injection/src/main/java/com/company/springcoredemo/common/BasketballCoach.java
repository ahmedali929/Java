package com.company.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasketballCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Practice shooting for 15 minutes!!!";
    }
}
