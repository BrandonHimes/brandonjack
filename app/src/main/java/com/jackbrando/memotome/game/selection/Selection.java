package com.jackbrando.memotome.game.selection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brando on 1/20/16.
 */
public class Selection {
    List<SelectionLink> links = null;

    public Selection() {
        initializeLinks();
    }

    public void addLink(SelectionLink link){
        links.add(link);
    }

    public void addLink(int startX, int startY, int endX, int endY){
        addLink(new SelectionLink(startX, startY, endX, endY));
    }

    public List<SelectionLink> getLinks(){
        return links;
    }

    public void initializeLinks(){
        links = new ArrayList<SelectionLink>(15);
    }
}