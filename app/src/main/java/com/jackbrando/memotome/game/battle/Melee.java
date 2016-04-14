package com.jackbrando.memotome.game.battle;

/**
 * Created by brando on 4/13/16.
 */
public class Melee implements BattleAction {

    private static int ATTACK_BASE_POWER = 1;

    @Override
    public void doAction(BattleCharacter attacker, BattleCharacter victim, int intensity) {
        int netAttack = ATTACK_BASE_POWER * intensity;
        int newHitPoints = victim.getHitPoints() - netAttack;
        victim.setHitPoints(newHitPoints);
    }
}
