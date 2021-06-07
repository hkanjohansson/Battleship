package battleship_game.ships;

import java.util.ArrayList;

/*
Placement of ships takes place in the Game class

TODO - Place the ships -> Two cases: x +- size or y +- size. If outside the gameplan: Try again or exception.
TODO - What will happen when a ship reaches 0 health?
TODO -
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
    public abstract void setXEnd(int shipSize); // Input +- ship size or 0
    public abstract void setYEnd(int shipSize); // Input +- ship size or 0
    public abstract ArrayList<int[]> getShipCoordinates(); // TODO - Return start and end points of x and y
    public abstract void reduceHealth();
    public abstract String toString();
}
