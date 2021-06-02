package battleship_game;

public abstract class Ship {
    protected int xCoordinate;
    protected int yCoordinate;
    protected int size;
    protected int health;

    public abstract int getHealth();
    public abstract int getXCoordinate();
    public abstract int getYCoordinate();
    public abstract void reduceHealth();
    public abstract String toString();
}
