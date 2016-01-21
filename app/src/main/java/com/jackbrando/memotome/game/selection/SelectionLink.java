package com.jackbrando.memotome.game.selection;

/**
 * Created by brando on 1/20/16.
 */
public class SelectionLink {
    private int startingX = -1;
    private int startingY = -1;
    private int endingX = -1;
    private int endingY = -1;

    public SelectionLink(int startingX, int startingY, int endingX, int endingY) {
        this.startingX = startingX;
        this.startingY = startingY;
        this.endingX = endingX;
        this.endingY = endingY;
    }

    public SelectionLink() {
    }

    public int getStartingX() {
        return startingX;
    }

    public void setStartingX(int startingX) {
        this.startingX = startingX;
    }

    public int getStartingY() {
        return startingY;
    }

    public void setStartingY(int startingY) {
        this.startingY = startingY;
    }

    public int getEndingX() {
        return endingX;
    }

    public void setEndingX(int endingX) {
        this.endingX = endingX;
    }

    public int getEndingY() {
        return endingY;
    }

    public void setEndingY(int endingY) {
        this.endingY = endingY;
    }
}
