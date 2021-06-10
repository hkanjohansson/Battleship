package battleship_game.ships;

import java.util.ArrayList;

/*
Placement of ships takes place in the Player class

TODO - What will happen when a ship reaches 0 health?

 */
public abstract class Ship {
    protected int xStart;
    protected int yStart;
    protected int xEnd;
    protected int yEnd;
    protected int size;
    protected int health;
    protected boolean alive;

    public abstract int getHealth();
    public abstract int[] getXCoordinate();
    public abstract int[] getYCoordinate();
    public abstract int getSize();
    public abstract void setXStart(int xStart);
    public abstract void setYStart(int yStart);
    public abstract void setXEnd(int shipSize);
    public abstract void setYEnd(int shipSize);
    public abstract ArrayList<int[]> getShipCoordinates(); // Return all ship coordinates
    public abstract void reduceHealth();
    public abstract String toString();
}
