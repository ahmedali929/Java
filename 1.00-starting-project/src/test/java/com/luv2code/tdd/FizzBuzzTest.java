package com.luv2code.tdd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    @DisplayName("Divisible by Three")
    @Test
    @Order(1)
    void testForDivisibleByThree() {
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    void testForDivisibleByFive() {
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }



}
