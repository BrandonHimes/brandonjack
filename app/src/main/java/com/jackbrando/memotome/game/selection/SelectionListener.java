package com.jackbrando.memotome.game.selection;

import android.view.MotionEvent;
import android.view.View;

import com.jackbrando.memotome.BattleActivity;
import com.jackbrando.memotome.game.battle.BattleCharacter;
import com.jackbrando.memotome.game.battle.BattleOption;
import com.jackbrando.memotome.game.Wheel;

/**
 * Created by brando on 3/30/16.
 */
public class SelectionListener implements View.OnTouchListener {
    private final BattleOption option;
    private final Wheel wheel;

    public SelectionListener(BattleOption option, Wheel wheel) {
        this.option = option;
        this.wheel = wheel;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        doSelection(v, event);
        return false;
    }

    private void doSelection(View v, MotionEvent event){
        float x = event.getX();
        float y = event.getY();
        int source = event.getSource();
        BattleActivity activity = (BattleActivity) v.getContext();
        Selection chosenSelection = null;
        for (Selection selection : activity.getSelections()) {
            if(selection.isSelected(option, wheel)){
                chosenSelection = selection;
            }
        }
        boolean isSelected = chosenSelection != null;
        System.out.println("This selection is " + isSelected + "ly legal");
        if(isSelected){
            BattleOption selectedOption = chosenSelection.getSelectedOption();
            System.out.println("Stand back!  I'm about to try " + selectedOption.getName() + " with the power of " + (chosenSelection.getLength() + 1));
            BattleCharacter hero = activity.getHero();
            BattleCharacter monster = activity.getMonster();
            System.out.println("Hero: " + hero.getHitPoints());
            System.out.println("Monster " + monster.getHitPoints());
            selectedOption.doAction(hero, monster, chosenSelection.getLength() + 1);
            System.out.println("BOOM!  Now hero has " + hero.getHitPoints() +
                    " and the monster has " + monster.getHitPoints() + "!!!111");

        }

    }
}
