package battleship_game;

public class Submarine extends Ship{

    public Submarine(int size, int health, int x, int y) {
        super.size = size;
        super.health = health;
        super.xCoordinate = x;
        super.yCoordinate = y;
    }


    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getXCoordinate() {
        return xCoordinate;
    }

    @Override
    public int getYCoordinate() {
        return yCoordinate;
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