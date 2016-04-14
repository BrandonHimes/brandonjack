package com.jackbrando.memotome.game.battle;

import com.jackbrando.memotome.BattleActivity;

/**
 * Created by brando on 4/13/16.
 */
public interface BattleAction {
    public void doAction(BattleCharacter attacker, BattleCharacter victim, int intensity);
}
