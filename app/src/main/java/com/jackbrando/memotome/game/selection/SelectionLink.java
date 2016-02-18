package com.jackbrando.memotome.game.selection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brando on 1/20/16.
 */
public class SelectionLink {
    private SelectionPoint startingPoint;
    private SelectionPoint endingPoint;

    public SelectionLink(SelectionPoint startingPoint, SelectionPoint endingPoint) {
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
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

    public List<SelectionPoint> getPoints(){
        List<SelectionPoint> points = new ArrayList<SelectionPoint>();
        points.add(startingPoint);
        points.add(endingPoint);
        return points;
    }

}
