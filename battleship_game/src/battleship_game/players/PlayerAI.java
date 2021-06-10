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
    public void placeShip() {

    }

    @Override
    public void fireWeapon() {

    }

    @Override
    public String toString() {
        return null;
    }
}
