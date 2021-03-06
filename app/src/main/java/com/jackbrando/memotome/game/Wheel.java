package com.jackbrando.memotome.game;

import com.jackbrando.memotome.game.battle.BattleOption;

/**
 * Created by brando on 11/4/15.
 */
public class Wheel {
    public static BattleOption[] BATTLE_OPTIONS = {BattleOption.melee, BattleOption.heal, BattleOption.magic, BattleOption.thieve, BattleOption.flee};
    private int index;
    private int spinPosition = 0;
    private BattleOption selection = null;

    public void setSpinPosition(int spinPosition) {
        this.spinPosition = spinPosition;
    }

    public Wheel(int index){
        this.index = index;
        spin();
    }

    public BattleOption getPreviousOption(){
        int previous = spinPosition-1;
        if(previous < 0){
            previous = BATTLE_OPTIONS.length-1;
        }
        return BATTLE_OPTIONS[previous];
    }

    public BattleOption getNextOption(){
        int next = spinPosition+1;
        if(next > BATTLE_OPTIONS.length-1){
            next = 0;
        }
        return BATTLE_OPTIONS[next];
    }

    public BattleOption getCurrentOption(){
        return BATTLE_OPTIONS[spinPosition];
    }

    public void spin(){
        int randomNum = (int) Math.round(Math.random() * (BATTLE_OPTIONS.length - 1));
        spinPosition = randomNum;
        selection = null;
    }

    public void selectPrevous(){
        selection = getPreviousOption();
    }

    public void selectCurrent(){
        selection = getCurrentOption();
    }

    public void selectNext(){
        selection = getNextOption();
    }

    public BattleOption getSelectedOption(){ return selection; }

    public int getIndex() {
        return index;
    }
}
