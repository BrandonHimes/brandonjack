package com.jackbrando.memotome.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.jackbrando.memotome.BattleActivity;
import com.jackbrando.memotome.game.Wheel;

/**
 * Created by brando on 12/2/15.
 */
public class WheelSelectionView extends ImageView {

    private static final int IMAGE_DIM = 70;
    private static final int MARGIN_DPS = 20;

    private Paint paint = new Paint();
    {
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(20f);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    private Canvas canvas = null;

    public WheelSelectionView(Context context) {
        super(context);
    }

    public WheelSelectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;

        BattleActivity activity = (BattleActivity) getContext();
        Wheel wheel1 = activity.getWheel1();
        System.out.println(wheel1.getCurrentOption());


        drawWheelOptionLink(0, 0, 0, 1);
        drawWheelOptionLink(0, 1, 1, 2);
        drawWheelOptionLink(1, 2, 2, 2);
        drawWheelOptionLink(2, 2, 3, 2);
        drawWheelOptionLink(3, 2, 4, 2);
    }

    private void drawWheelOptionLink(int x1, int y1, int x2, int y2){
        canvas.drawLine(convertToImageCenterCoord(x1), convertToImageCenterCoord(y1),
                convertToImageCenterCoord(x2), convertToImageCenterCoord(y2), paint);
    }

    private float convertToImageCenterCoord(int pos){
        return (pos * IMAGE_DIM + (new Float(.5) * IMAGE_DIM)) * getResources().getDisplayMetrics().density + MARGIN_DPS;
    }
}
