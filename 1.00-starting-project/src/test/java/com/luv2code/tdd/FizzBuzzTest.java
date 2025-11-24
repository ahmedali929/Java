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

    @DisplayName("Divisible by Five")
    @Test
    @Order(2)
    void testForDivisibleByFive() {
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    @DisplayName("Divisible by Three and Five")
    @Test
    @Order(3)
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }


}
