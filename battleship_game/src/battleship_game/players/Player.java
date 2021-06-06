package battleship_game.players;

import battleship_game.ships.Ship;

import java.util.List;

public abstract class Player {
    protected int score;
    protected int totalHealth;
    protected List<Ship> ships;

    public abstract int getScore();
    public abstract int getTotalHealth();
    public abstract List<Ship> getShips();
    public abstract void addShip(Ship s);
    public abstract void fireWeapon(); // If hit, increase score
    public abstract String toString(); // Print game area in each turn
}
