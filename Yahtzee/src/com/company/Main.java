package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Random random = new Random();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here

        List<Integer> currentDice = new ArrayList<>();

        int rolls = 0;
        do {
            rollDice(currentDice);
            currentDice.clear();
        } while (++rolls < 5);

    }

    private static void rollDice(List<Integer> currentDice) {
        int randomCount = 5 - currentDice.size();

        var newDice = random.ints(randomCount, 1, 7)
                .sorted()
                .boxed()
                .toList();

        currentDice.addAll(newDice);

        System.out.println("Your dice are: " + currentDice);
    }

    private static boolean pickLosers(List<Integer> currendDice) {

        String prompt = """
                
                Press Enter to Score.
                Type "ALL" to re-roll all the dice.
                List numbers (separated by spaces) to re-roll selected dice.
                
                """;
        System.out.println(prompt + "--> ");
    }
}
