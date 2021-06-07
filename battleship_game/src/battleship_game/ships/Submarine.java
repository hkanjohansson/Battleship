package battleship_game.ships;

import java.util.ArrayList;

public class Submarine extends Ship{

    public Submarine(int size, int health, int x, int y) {
        super.size = size;
        super.health = health;
        super.xStart = x;
        super.yStart = y;
    }


    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int[] getXCoordinate() {

        return new int[] {xStart, xEnd};
    }

    @Override
    public int[] getYCoordinate() {
        return new int[] {yStart, yEnd};
    }

    @Override
    public void setXEnd(int shipSize) {

    }

    @Override
    public void setYEnd(int shipSize) {

    }

    @Override
    public ArrayList<int[]> getShipCoordinates() {
        return null;
    }

    @Override
    public void reduceHealth() {
        health--;
    }

    // TODO - Write toString method
    @Override
    public String toString() {
        return null;
    }
}
