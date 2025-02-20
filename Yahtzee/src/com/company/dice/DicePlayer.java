package com.company.dice;

import java.util.*;

public class DicePlayer implements dev.lpa.game.Player {

    private final String name;
    private final List<Integer> currentDice = new ArrayList<>();
    private final Map<dev.lpa.dice.ScoredItem, Integer> scoreCard = new EnumMap<>(dev.lpa.dice.ScoredItem.class);

    public DicePlayer(String name) {
        this.name = name;
        for (dev.lpa.dice.ScoredItem item : dev.lpa.dice.ScoredItem.values()) {
            scoreCard.put(item, null);
        }
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "DicePlayer{" +
                "name='" + name + '\'' +
                ", currentDice=" + currentDice +
                ", scoreCard=" + scoreCard +
                '}';
    }

    public void rollDice() {
        int randomCount = 5 - currentDice.size();

        var newDice = new Random()
                .ints(randomCount, 1, 7)
                .sorted()
                .boxed()
                .toList();

        currentDice.addAll(newDice);

        System.out.println("Your dice are: " + currentDice);
    }

}
