package battleship_game.players;

import battleship_game.ships.Ship;

import java.util.ArrayList;
import java.util.List;

public class PlayerHuman extends Player {


    public PlayerHuman() {
        ships = new ArrayList<>();
        totalHealth = 0;

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
    public void fireWeapon(int x, int y) {

    }

    @Override
    public String toString() {
        StringBuilder gameArea = new StringBuilder();

        for (int i = 0; i < WIDTH; i++) {
            gameArea.append("-   ");
        }
        gameArea.append("\n");

        String temp = gameArea.toString();

        for (int i = 0; i < HEIGHT; i++) {
            gameArea.append(temp);
        }
        return gameArea.toString();
    }
}
