package com.jackbrando.memotome.game.selection;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import com.jackbrando.memotome.BattleActivity;
import com.jackbrando.memotome.game.BattleOption;
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
        boolean isLegal = false;
        for (Selection selection : activity.getSelections()) {
            if(selection.isSelected(option, wheel)){
                isLegal = true;
            }
        }
    }
}
