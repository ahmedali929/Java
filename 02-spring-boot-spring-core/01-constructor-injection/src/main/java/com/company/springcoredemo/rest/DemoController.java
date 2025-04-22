package com.company.springcoredemo.rest;

import com.company.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency
    private Coach theCoach;

    @Autowired
    public DemoController(Coach theCoach) {
        this.theCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return theCoach.getDailyWorkout();
    }





}
