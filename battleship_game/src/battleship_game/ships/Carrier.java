package battleship_game.ships;

import java.util.ArrayList;

public class Carrier extends Ship{

    public Carrier() {
        super.alive = true;
        super.size = 5;
        super.health = 5;

    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int[] getXCoordinate() {
        return new int[]{xStart, xEnd};
    }

    @Override
    public int[] getYCoordinate() {
        return new int[]{yStart, yEnd};
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setXStart(int xStart) {
        super.xStart = xStart;
    }

    @Override
    public void setYStart(int yStart) {
        super.yStart = yStart;
    }

    @Override
    public void setXEnd(int shipSize) {
        xEnd = xStart + shipSize;
    }

    @Override
    public void setYEnd(int shipSize) {
        yEnd = yStart + shipSize;
    }

    @Override
    public ArrayList<int[]> getShipCoordinates() {
        int diffX = xEnd - xStart;
        int diffY = yEnd - yStart;

        ArrayList<int[]> coordinates = new ArrayList<>();

        if (diffX > 0) {
            for (int i = 0; i < diffX; i ++) {
                coordinates.add(new int[]{xStart + i, yStart});
            }

        } else {
            for (int i = 0; i < diffY; i ++) {
                coordinates.add(new int[]{xStart, yStart + i});
            }

        }

        return coordinates;
    }

    @Override
    public void reduceHealth() {

        if (health > 0) {
            health--;
        } else {
            alive = false;
        }

    }

    // TODO - Print coordinates of ship
    @Override
    public String toString() {
        return "This is a carrier. The carrier is of size: " + size + ".";
    }
}
