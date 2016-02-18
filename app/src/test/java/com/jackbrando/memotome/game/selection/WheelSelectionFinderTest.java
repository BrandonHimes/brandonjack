package com.jackbrando.memotome.game.selection;

import com.jackbrando.memotome.game.Wheel;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


/**
 * Created by brando on 2/17/16.
 */
public class WheelSelectionFinderTest {
    @Test
    public void testFindSelectionsLucky() throws Exception {

        ArrayList<Wheel> wheels = new ArrayList<>();

        Wheel wheel1 = new Wheel();
        Wheel wheel2 = new Wheel();
        Wheel wheel3 = new Wheel();
        Wheel wheel4 = new Wheel();
        Wheel wheel5 = new Wheel();

        wheel1.setSpinPosition(1);
        wheel2.setSpinPosition(1);
        wheel3.setSpinPosition(1);
        wheel4.setSpinPosition(1);
        wheel5.setSpinPosition(1);

        wheels.add(wheel1);
        wheels.add(wheel2);
        wheels.add(wheel3);
        wheels.add(wheel4);
        wheels.add(wheel5);

        List<Selection> selections = WheelSelectionFinder.findSelections(wheels);

        assertTrue(selections.size() == 3);
        for(Selection selection : selections){
            System.out.println("New selection:");
            assertTrue(selection.getLength() == 4);
            for(SelectionLink link : selection.getLinks()){
                System.out.println(link.getStartingPoint().getX() + "," + link.getStartingPoint().getY() + " - " +
                        link.getEndingPoint().getX() + "," + link.getEndingPoint().getY());
            }
        }
    }

    @Test
    public void testFindSelectionsZiggyZaggy() throws Exception {

        ArrayList<Wheel> wheels = new ArrayList<>();

        Wheel wheel1 = new Wheel();
        Wheel wheel2 = new Wheel();
        Wheel wheel3 = new Wheel();
        Wheel wheel4 = new Wheel();
        Wheel wheel5 = new Wheel();

        wheel1.setSpinPosition(0);
        wheel2.setSpinPosition(1);
        wheel3.setSpinPosition(2);
        wheel4.setSpinPosition(3);
        wheel5.setSpinPosition(4);

        wheels.add(wheel1);
        wheels.add(wheel2);
        wheels.add(wheel3);
        wheels.add(wheel4);
        wheels.add(wheel5);

        List<Selection> selections = WheelSelectionFinder.findSelections(wheels);

        assertTrue(selections.size() == 5);
        for(Selection selection : selections){
            System.out.println("New selection:");
            assertTrue(selection.getLength() > 0 && selection.getLength() < 3);
            for(SelectionLink link : selection.getLinks()){
                System.out.println(link.getStartingPoint().getX() + "," + link.getStartingPoint().getY() + " - " +
                        link.getEndingPoint().getX() + "," + link.getEndingPoint().getY());
            }
        }
    }
}