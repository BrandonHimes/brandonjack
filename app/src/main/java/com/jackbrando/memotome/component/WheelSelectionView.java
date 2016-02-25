package com.jackbrando.memotome.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.jackbrando.memotome.BattleActivity;
import com.jackbrando.memotome.game.Wheel;
import com.jackbrando.memotome.game.selection.SelectionLine;
import com.jackbrando.memotome.game.selection.SelectionLink;
import com.jackbrando.memotome.game.selection.SelectionPoint;
import com.jackbrando.memotome.game.selection.WheelSelectionFinder;
import com.jackbrando.memotome.game.selection.Selection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brando on 12/2/15.
 */
public class WheelSelectionView extends ImageView {

    private static final int IMAGE_DIM = 70;
    private static final int MARGIN_DPS = 20;



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
        List<Wheel> wheels = new ArrayList<Wheel>();
        wheels.add(activity.getWheel1());
        wheels.add(activity.getWheel2());
        wheels.add(activity.getWheel3());
        wheels.add(activity.getWheel4());
        wheels.add(activity.getWheel5());
        List<Selection> selections = WheelSelectionFinder.findSelections(wheels);
        for(Selection selection : selections){
            for(SelectionLink link : selection.getLinks()){
                drawWheelOptionLink(link);
            }
        }
    }

    private void drawWheelOptionLink(SelectionLink link){
        SelectionLine.getLine().setColor(link.getOption().getColor());
        SelectionPoint start = link.getStartingPoint();
        SelectionPoint end = link.getEndingPoint();
        canvas.drawLine(convertToImageCenterCoord(start.getX()), convertToImageCenterCoord(start.getY()),
                convertToImageCenterCoord(end.getX()), convertToImageCenterCoord(end.getY()), SelectionLine.getLine());
    }

    private float convertToImageCenterCoord(int pos){
        return (pos * IMAGE_DIM + (new Float(.5) * IMAGE_DIM)) * getResources().getDisplayMetrics().density + MARGIN_DPS;
    }
}
