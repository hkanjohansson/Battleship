package battleship_game.players;

import battleship_game.ships.Ship;

import java.util.List;

public abstract class Player {

    protected final int NUMBER_OF_SHIPS = 5;
    protected final int WIDTH = 10;
    protected final int HEIGHT = 10;
    protected int score;
    protected int totalHealth;
    protected List<Ship> ships;

    public abstract int getScore();
    public abstract int getTotalHealth();
    public abstract List<Ship> getShips();
    public abstract void placeShip(Ship s);
    public abstract void fireWeapon(int x, int y); // If hit, increase score
    public abstract String toString(); // Print game area in each turn
}
