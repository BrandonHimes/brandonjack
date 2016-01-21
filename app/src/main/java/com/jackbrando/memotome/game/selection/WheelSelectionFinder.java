package com.jackbrando.memotome.game.selection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brando on 1/20/16.
 */
public class WheelSelectionFinder {

    public static List<Selection> findSelections(){
        List<Selection> selections = new ArrayList<Selection>(3);

        Selection fakeSelection = new Selection();

        fakeSelection.addLink(0, 0, 0, 1);
        fakeSelection.addLink(0, 1, 1, 2);
        fakeSelection.addLink(1, 2, 2, 2);
        fakeSelection.addLink(2, 2, 3, 2);
        fakeSelection.addLink(3, 2, 4, 1);

        selections.add(fakeSelection);

        return selections;
    }

}
