package com.jackbrando.memotome.game.battle;

import android.graphics.Color;

/**
 * Created by brando on 2/24/16.
 */
public class BattleOption {
    private String name;
    private int color;
    private BattleAction action;

    public static final int ALPHA = 100;
    public static BattleOption melee = new BattleOption("melee", Color.argb(ALPHA, 255, 0, 0), new Melee());
    public static BattleOption heal = new BattleOption("heal", Color.argb(ALPHA, 0, 0, 255), new Heal());
    public static BattleOption magic = new BattleOption("magic", Color.argb(ALPHA, 0, 255, 0), new Magic());
    public static BattleOption thieve = new BattleOption("thieve", Color.argb(ALPHA, 220, 0, 128), new Thieve());
    public static BattleOption flee = new BattleOption("flee", Color.argb(ALPHA, 220, 220, 0), new Flee());

    public BattleOption(String name, int color, BattleAction action) {
        this.name = name;
        this.color = color;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void doAction(BattleCharacter attacker, BattleCharacter victim, int intensity) {
        action.doAction(attacker, victim, intensity);
    }

    public BattleAction getAction(){
        return action;
    }

    public void setAction(BattleAction action) {
        this.action = action;
    }

}
