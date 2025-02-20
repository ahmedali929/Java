package com.company.dice;

import dev.lpa.game.GameAction;

import java.util.LinkedHashMap;
import java.util.Map;

public class DiceGame extends dev.lpa.game.Game<DicePlayer> {
    public DiceGame(String gameName) {
        super(gameName);
    }

    @Override
    public DicePlayer createNewPlayer(String name) {
        return new DicePlayer(name);
    }

    @Override
    public Map<Character, dev.lpa.game.GameAction> getGameActions(int playerIndex) {

        Map<Character, dev.lpa.game.GameAction> map = new LinkedHashMap<>(Map.of('R', new GameAction('R', "Roll Dice", this::rollDice)));
        map.putAll(getStandardActions());
        return map;

    }

    private boolean rollDice(int playerIndex) {
        getPlayer(playerIndex).rollDice();
        return false;
    }
}
