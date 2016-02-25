package com.jackbrando.memotome.game;

import android.graphics.Color;

/**
 * Created by brando on 2/24/16.
 */
public class BattleOption {
    private String name;
    private int color;

    public static final int ALPHA = 100;
    public static BattleOption melee = new BattleOption("melee", Color.argb(ALPHA, 255, 0, 0));
    public static BattleOption heal = new BattleOption("heal", Color.argb(ALPHA, 0, 0, 255));
    public static BattleOption magic = new BattleOption("magic", Color.argb(ALPHA, 0, 255, 0));
    public static BattleOption thieve = new BattleOption("thieve", Color.argb(ALPHA, 220, 0, 128));
    public static BattleOption flee = new BattleOption("flee", Color.argb(ALPHA, 220, 220, 0));

    public BattleOption(String name, int color) {
        this.name = name;
        this.color = color;
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
}
