package com.company.springcoredemo.rest;

import com.company.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency
    private Coach theCoach;
    //private Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("basketballCoach") Coach theCoach
           //@Qualifier("basketballCoach") Coach anotherCoach
    ) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.theCoach = theCoach;
        //this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return theCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check() {
//        return "Comparing beans: theCoach == anotherCoach, " + (theCoach == anotherCoach);
//    }





}
