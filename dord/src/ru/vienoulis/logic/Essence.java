package ru.vienoulis.logic;

public class Essence {
    private int alive;
    private Coord coord;

    public Essence(int alive) {
        this.alive = alive;
    }

    public Essence(int alive, int x , int y) {
        this.alive = alive;
        this.coord = new Coord(x , y);
    }

    public int getAlive() {

        return alive;
    }

    @Override
    public String toString() {
            return alive + " ";

    }
}
