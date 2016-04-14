package com.jackbrando.memotome.game.selection;

import com.jackbrando.memotome.game.battle.BattleOption;
import com.jackbrando.memotome.game.Wheel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brando on 1/20/16.
 */
public class WheelSelectionFinder {

    //This is 1 if selections must begin in the first column, 5 if they can start anywhere
    public static final int MAX_ALLOWED_STARTING_XS = 1;
    public static int MAX_X = 5;
    public static int MAX_Y = 3;

    public static List<Selection> findSelections(List<Wheel> wheels){
        List<Selection> selections = new ArrayList<Selection>(3);

        for(int x=0; x< MAX_ALLOWED_STARTING_XS; x++){
            for(int y=0; y< MAX_Y; y++){
                Selection selection = new Selection();
                SelectionPoint point = new SelectionPoint(x,y);
                selection = findLongestSelection(point, wheels, selection, selections);
                if(selection.getLength() > 0){
                    selections.add(selection);
                }
            }
        }

        return selections;
    }

    private static Selection findLongestSelection(SelectionPoint point, List<Wheel> wheels, Selection selection, List<Selection> existingSelections) {
        System.out.println("Checking for selections starting at " + point.getX() + "," + point.getY());
        List<SelectionPoint> adjacentPoints = new ArrayList<SelectionPoint>();
        adjacentPoints.add(new SelectionPoint(point.getX()+1, point.getY()));
        adjacentPoints.add(new SelectionPoint(point.getX()-1, point.getY()));
        adjacentPoints.add(new SelectionPoint(point.getX()+1, point.getY()-1));
        adjacentPoints.add(new SelectionPoint(point.getX()+1, point.getY()+1));
        adjacentPoints.add(new SelectionPoint(point.getX()-1, point.getY()-1));
        adjacentPoints.add(new SelectionPoint(point.getX()-1, point.getY()+1));

        for(SelectionPoint adjacentPoint : adjacentPoints){
            Selection newSelection = new Selection(selection);
            if(isValidPoint(adjacentPoint) && isMatchingOption(point, adjacentPoint, wheels) && !isAlreadyUsed(adjacentPoint, existingSelections, newSelection)) {
                BattleOption option = getOptionY(wheels.get(point.getX()), point.getY());
                SelectionLink newLink = new SelectionLink(point, adjacentPoint, option);
                newSelection.addLink(newLink);
                if(newSelection.getLength() > selection.getLength()){
                    System.out.println("Going from " + point.getX() + "," + point.getY() + " to " + adjacentPoint.getX() + "," + adjacentPoint.getY());
                    selection = findLongestSelection(adjacentPoint, wheels, newSelection, existingSelections);
                }
            }
        }

        return selection;

    }

    private static boolean isValidPoint(SelectionPoint point){
        return (point.getX() > -1 && point.getY() > -1 && point.getX() < MAX_X && point.getY() < MAX_Y);
    }

    private static boolean isMatchingOption(SelectionPoint point1, SelectionPoint point2, List<Wheel> wheels){
        BattleOption option1 = getOptionY(wheels.get(point1.getX()), point1.getY());
        BattleOption option2 = getOptionY(wheels.get(point2.getX()), point2.getY());
        return option1.equals(option2);
    }

    private static BattleOption getOptionY(Wheel wheel, int y){
        if(y<2){
            if(y<1){
                return wheel.getPreviousOption();
            }else{
                return wheel.getCurrentOption();
            }
        }else{
            return wheel.getNextOption();
        }
    }

    private static boolean isAlreadyUsed(SelectionPoint currentPoint, List<Selection> selections, Selection newSelection){
        List<Selection> allSelections = new ArrayList<Selection>();
        allSelections.addAll(selections);
        allSelections.add(newSelection);
        for(Selection sel : allSelections){
            for(SelectionLink link : sel.getLinks()){
                for(SelectionPoint point : link.getPoints()){
                    if(point.equals(currentPoint)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
