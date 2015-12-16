package com.jackbrando.memotome.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
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

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(1f);

        canvas.drawLine(0,0,35,35,paint);
        canvas.drawLine(35,35,70,35,paint);
    }
}
