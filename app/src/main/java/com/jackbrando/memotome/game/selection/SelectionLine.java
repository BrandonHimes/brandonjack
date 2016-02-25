package com.jackbrando.memotome.game.selection;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PathEffect;

/**
 * Created by brando on 2/24/16.
 */
public class SelectionLine {
    private static Paint line = null;

    public static Paint getLine(){
        if (line == null){
            line = new Paint();
            line.setColor(Color.BLACK);
            line.setStrokeWidth(80f);
            line.setStrokeCap(Paint.Cap.ROUND);
        }
        return line;
    }
}
