package battleship_game.players;

import battleship_game.ships.Ship;

import java.util.List;

public abstract class Player {

    protected final int NUMBER_OF_SHIPS = 5;
    protected final int WIDTH = 10;
    protected final int HEIGHT = 10;
    protected int[][] shipsArea;
    protected int[][] fireArea;
    protected int score;
    protected int totalHealth;
    protected List<Ship> ships;

    public abstract int getScore(); // Return score
    public abstract void setScore(int s); // Increase score
    public abstract int getTotalHealth();
    public abstract void setTotalHealth(); // Decrease total health if hit

    public abstract int[][] getShipsArea();
    public abstract int[][] getFireArea();
    public abstract void placeShip();
    public abstract int[] fireWeapon(); // If hit, increase score
    public abstract String toString(); // Print game area in each turn
}
