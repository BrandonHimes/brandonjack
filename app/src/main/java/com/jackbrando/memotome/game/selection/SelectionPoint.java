package com.jackbrando.memotome.game.selection;

/**
 * Created by brando on 2/10/16.
 */
public class SelectionPoint {
    private int x = -1;

    private int y = -1;

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public SelectionPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectionPoint that = (SelectionPoint) o;

        if (getX() != that.getX()) return false;
        return y == that.y;

    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + y;
        return result;
    }
}
