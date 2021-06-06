package battleship_game;

/*
Placement of ships takes place in the Game class

TODO - Place the ships -> Two cases: x +- size or y +- size. If outside the gameplan: Try again or exception.
TODO - What will happen when a ship reaches 0 health?
TODO -
 */
public abstract class Ship {
    protected int xCoordinate; // TODO - Should these fields be protected or private?
    protected int yCoordinate;
    protected int size;
    protected int health;

    public abstract int getHealth();
    public abstract int getXCoordinate();
    public abstract int getYCoordinate();
    public abstract void reduceHealth();
    public abstract String toString();
}
