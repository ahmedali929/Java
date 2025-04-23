package com.company.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BasketballCoach implements Coach {

    public BasketballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

//    define out init method
//    @PostConstruct
//    public void doMyStartupStuff() {
//        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
//    }
//
//    define out destroy method
//    @PreDestroy
//    public void doMyCleanupStuff() {
//        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice shooting for 15 minutes!!!";
    }






}
