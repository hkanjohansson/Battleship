package battleship_game.players;

import battleship_game.ships.Ship;

import java.util.List;

public class PlayerAI extends Player{


    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public int getTotalHealth() {
        return 0;
    }

    @Override
    public List<Ship> getShips() {
        return null;
    }

    @Override
    public void placeShip(Ship s) {

    }

    @Override
    public void fireWeapon(int x, int y) {

    }

    @Override
    public String toString() {
        return null;
    }
}
