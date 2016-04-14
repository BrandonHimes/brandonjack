package com.jackbrando.memotome.game.battle;

/**
 * Created by brando on 4/13/16.
 */
public class Heal implements BattleAction {
    private static double HEAL_BASE_POWER = 1.5;

    @Override
    public void doAction(BattleCharacter attacker, BattleCharacter victim, int intensity) {
        int hitPoints = attacker.getHitPoints();
        int healPoints = (int) Math.round(HEAL_BASE_POWER * intensity);
        attacker.setHitPoints(hitPoints + healPoints);
    }
}
