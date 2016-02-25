package com.jackbrando.memotome.game.selection;

import com.jackbrando.memotome.game.BattleOption;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brando on 1/20/16.
 */
public class SelectionLink {
    private SelectionPoint startingPoint;
    private SelectionPoint endingPoint;

    private BattleOption option;

    public SelectionLink(SelectionPoint startingPoint, SelectionPoint endingPoint, BattleOption option) {
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.option = option;
    }

    public SelectionPoint getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(SelectionPoint endingPoint) {
        this.endingPoint = endingPoint;
    }

    public SelectionPoint getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(SelectionPoint start) {
        this.startingPoint = start;
    }

    public BattleOption getOption() {
        return option;
    }

    public void setOption(BattleOption option) {
        this.option = option;
    }

    public List<SelectionPoint> getPoints(){
        List<SelectionPoint> points = new ArrayList<SelectionPoint>();
        points.add(startingPoint);
        points.add(endingPoint);
        return points;
    }

}
