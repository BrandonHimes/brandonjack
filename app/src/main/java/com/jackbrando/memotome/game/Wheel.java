package com.jackbrando.memotome.game;

/**
 * Created by brando on 11/4/15.
 */
public class Wheel {
    public static String[] BATTLE_OPTIONS = {"melee", "heal", "magic", "thieve", "flee"};

    int spinPosition = 0;
    String selection = null;

    public void setSpinPosition(int spinPosition) {
        this.spinPosition = spinPosition;
    }

    public Wheel(){
        spin();
    }

    public String getPreviousOption(){
        int previous = spinPosition-1;
        if(previous < 0){
            previous = BATTLE_OPTIONS.length-1;
        }
        return BATTLE_OPTIONS[previous];
    }

    public String getNextOption(){
        int next = spinPosition+1;
        if(next > BATTLE_OPTIONS.length-1){
            next = 0;
        }
        return BATTLE_OPTIONS[next];
    }

    public String getCurrentOption(){
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

    public String getSelectedOption(){ return selection; }

}
