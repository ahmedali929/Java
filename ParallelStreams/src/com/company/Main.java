package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int numbersLength = 100_000_000;
        long[] numbers = new Random().longs(numbersLength, 1, numbersLength).toArray();

        long delta = 0; //tracks time difference between sequential and parallel computations
        int iterations = 25; //how many times we want to run the computations

        //seeing how long it takes to do sequential computation vs parallel computation
        for (int i = 0; i < iterations; i++) {
            long start = System.nanoTime();
            double averageSerial = Arrays.stream(numbers).average().orElseThrow();
            long elapsedSerial = System.nanoTime() - start;

            start = System.nanoTime();
            double averageParallel = Arrays.stream(numbers).parallel().average().orElseThrow();
            long elapsedParallel = System.nanoTime() - start;

            delta += (elapsedSerial - elapsedParallel);
        }

        System.out.printf("Parallel is [%d] nanos or [%.2f] ms faster on average %n", delta/iterations, delta/ 1000000.0 / iterations);

    }


}
