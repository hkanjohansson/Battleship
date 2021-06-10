package battleship_game.players;

import battleship_game.ships.Ship;

import java.util.List;

public class PlayerAI extends Player{


    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void setScore(int s) {
        score += s;
    }

    @Override
    public int getTotalHealth() {
        return 0;
    }

    @Override
    public void setTotalHealth() {

    }

    @Override
    public List<Ship> getShips() {
        return null;
    }

    @Override
    public int[][] getShipsArea() {
        return new int[0][];
    }

    @Override
    public int[][] getFireArea() {
        return new int[0][];
    }

    @Override
    public void placeShip() {

    }

    @Override
    public int[] fireWeapon() {

        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
