package com.jackbrando.memotome.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by brando on 12/2/15.
 */
public class WheelOptionView extends ImageView {

    private Paint paint = new Paint();

    public WheelOptionView(Context context) {
        super(context);
    }

    public WheelOptionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(20f);
        paint.setStrokeCap(Paint.Cap.ROUND);

        canvas.drawLine(10, 10, 1000, 1000, paint);
        canvas.drawLine(100, 10, 100, 100, paint);
        canvas.drawLine(200, 10, 100, 100, paint);
        canvas.drawLine(10, 100, 100, 100, paint);
        canvas.drawLine(100, 100, 100, 100, paint);
        canvas.drawLine(200, 100, 100, 100, paint);
        canvas.drawLine(10, 200, 100, 100, paint);
        canvas.drawLine(100, 200, 100, 100, paint);
        canvas.drawLine(200, 200, 100, 100, paint);
    }
}
