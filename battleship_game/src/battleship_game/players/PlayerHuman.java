package battleship_game.players;

import battleship_game.Game;
import battleship_game.ships.Ship;

import java.util.ArrayList;
import java.util.List;

public class PlayerHuman extends Player{
    private final int NUMBER_OF_SHIPS = 5;

    public PlayerHuman () {
        super.ships = new ArrayList<>();
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getTotalHealth() {
        return totalHealth;
    }

    @Override
    public List<Ship> getShips() {
        return ships;
    }

    @Override
    public void addShip(Ship s) {
        if (ships.size() < NUMBER_OF_SHIPS) {
            ships.add(s);
        }

    }

    @Override
    public void fireWeapon() {

    }

    @Override
    public String toString() {
        StringBuilder gameArea = new StringBuilder();

        for (int i = 0; i < width; i++) {
            gameArea.append("-   ");
        }
        gameArea.append("\n");

        String temp = gameArea.toString();

        for (int i = 0; i < height; i++) {
            gameArea.append(temp);
        }
        return gameArea.toString();
    }
}
