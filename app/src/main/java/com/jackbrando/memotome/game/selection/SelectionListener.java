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
        BattleActivity activity = (BattleActivity) v.getContext();
        if(activity.isActionable()) {
            float x = event.getX();
            float y = event.getY();
            int source = event.getSource();

            Selection chosenSelection = null;
            for (Selection selection : activity.getSelections()) {
                if (selection.isSelected(option, wheel)) {
                    chosenSelection = selection;
                }
            }
            boolean isSelected = chosenSelection != null;
            System.out.println("This selection is " + isSelected + "ly legal");
            if (isSelected) {
                activity.takeAction(chosenSelection);

            }
        }
    }
}
