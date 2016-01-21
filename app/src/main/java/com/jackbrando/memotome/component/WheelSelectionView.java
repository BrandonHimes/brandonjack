package com.jackbrando.memotome.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.jackbrando.memotome.BattleActivity;
import com.jackbrando.memotome.game.Wheel;
import com.jackbrando.memotome.game.selection.SelectionLink;
import com.jackbrando.memotome.game.selection.WheelSelectionFinder;
import com.jackbrando.memotome.game.selection.Selection;

import java.util.List;

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

        List<Selection> selections = WheelSelectionFinder.findSelections();
        for(Selection selection : selections){
            for(SelectionLink link : selection.getLinks()){
                drawWheelOptionLink(link.getStartingX(), link.getStartingY(), link.getEndingX(), link.getEndingY());
            }
        }
    }

    private void drawWheelOptionLink(int x1, int y1, int x2, int y2){
        canvas.drawLine(convertToImageCenterCoord(x1), convertToImageCenterCoord(y1),
                convertToImageCenterCoord(x2), convertToImageCenterCoord(y2), paint);
    }

    private float convertToImageCenterCoord(int pos){
        return (pos * IMAGE_DIM + (new Float(.5) * IMAGE_DIM)) * getResources().getDisplayMetrics().density + MARGIN_DPS;
    }
}
