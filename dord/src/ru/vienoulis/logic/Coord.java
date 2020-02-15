package ru.vienoulis.logic;

public class Coord {
    private int x;
    private int y;


    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "||x = " + x + ", y = " + y;
    }
}
