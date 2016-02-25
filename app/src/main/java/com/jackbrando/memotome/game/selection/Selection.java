package com.jackbrando.memotome.game.selection;

import com.jackbrando.memotome.game.BattleOption;

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
}