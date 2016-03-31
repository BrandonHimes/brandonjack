package com.jackbrando.memotome.game.selection;

import com.jackbrando.memotome.game.BattleOption;
import com.jackbrando.memotome.game.Wheel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brando on 1/20/16.
 */
public class Selection {
    List<SelectionLink> links = null;

    public Selection(Selection existingSelection) {
        initializeLinks();
        List<SelectionLink> links = existingSelection.getLinks();
        for(SelectionLink link : links){
            addLink(link);
        }
    }

    public Selection() {
        initializeLinks();
    }

    public void addLink(SelectionLink link){
        links.add(link);
    }

    public void addLink(int startX, int startY, int endX, int endY, BattleOption option){
        SelectionPoint startingPoint = new SelectionPoint(startX, startY);
        SelectionPoint endingPoint = new SelectionPoint(endX, endY);
        addLink(new SelectionLink(startingPoint, endingPoint, option));
    }

    public List<SelectionLink> getLinks(){
        return links;
    }

    public void initializeLinks(){
        links = new ArrayList<SelectionLink>(15);
    }

    public int getLength(){
        return links.size();
    }

    public boolean isSelected(BattleOption option, Wheel wheel){
        boolean result = false;
        for (SelectionLink link : links) {
            for(SelectionPoint point : link.getPoints()){
                if( isOnSameWheelAsSelection(wheel, point)
                        && isSameOptionAsSelection(option, link)){
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean isSameOptionAsSelection(BattleOption option, SelectionLink link) {
        return link.getOption() == option;
    }

    private boolean isOnSameWheelAsSelection(Wheel wheel, SelectionPoint point) {
        return (point.getX()+1) == wheel.getIndex();
    }

}