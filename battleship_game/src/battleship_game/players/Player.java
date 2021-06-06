package battleship_game.players;

import battleship_game.ships.Ship;

import java.util.List;

public abstract class Player {
    protected int score;
    protected int totalHealth;
    protected List<Ship> ships;

    public abstract void addShip(Ship s);
    public abstract void fireWeapon(); // If hit, increase score
    public abstract String toString(); // Print status in each turn
}
