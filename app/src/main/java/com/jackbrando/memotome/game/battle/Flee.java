package com.jackbrando.memotome.game.battle;

/**
 * Created by brando on 4/13/16.
 */
public class Flee implements BattleAction {

    @Override
    public void doAction(BattleCharacter attacker, BattleCharacter victim, int intensity) {
        System.exit(0);
    }
}
