package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Challenge 1
        String sentence = "Hello, World!";
        boolean matches = sentence.matches("Hello, World!");
        System.out.println(matches);

        //Challenge 2
        String sentence2 = "[A-Z].*\\.";
        for (String s : List.of("The bike is red.", "I am a new student.", "hello world.", "How are you?")) {
            boolean matched = s.matches(sentence2);
            System.out.println(matched + ": " + s);
        }

        //Challenge 3
        String sentence3 = "[A-Z].+[.?!]";
        for (String s : List.of("The bike is red, and has flat tires.", "I love being a new L.P.A student!", "Hello, friends and family: Welcome!", "How are you, Mary?")) {
            boolean matched = s.matches(sentence3);
            System.out.println(matched + ": " + s);
        }

    }
}
