package com.jackbrando.memotome.game.selection;

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

    public void addLink(int startX, int startY, int endX, int endY){
        addLink(new SelectionLink(new SelectionPoint(startX, startY), new SelectionPoint(endX, endY)));
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