package battleship_game.players;

import battleship_game.ships.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerHuman extends Player {

    /*
    TODO - Initialize the ships list with all the types of ships
     */
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
    public void placeShip(Ship s) {

        Scanner in = new Scanner(System.in);
        boolean placed = false;

        if (ships.size() < NUMBER_OF_SHIPS) {
            ships.add(s);
        }

        /*
        TODO - Set all the coordinates in this class
             - Check for available coordinates
             - If an occupied coordinate is chosen, start all over with the placement
         */

        while (!placed) {
            System.out.println("Choose your start coordinates");

            System.out.println("Do you want to place horizontal, then input ship size? " +
                    "If not, input 0 (or a smaller integer) to proceed to vertical");

            int x = in.nextInt();
            int shipSize = s.getSize();

            if (x > 0 && s.getXCoordinate()[0] + shipSize <= 10) {
                s.setXEnd(shipSize);
                placed = true;

            } else if (s.getYCoordinate()[0] + shipSize <= 10){
                System.out.println("Hej");
                s.setYEnd(shipSize);
                placed = true;
            } else {
                System.out.println("Try placing your ship correctly");
            }

        }

    }

    @Override
    public void fireWeapon(int x, int y) {

    }

    @Override
    public String toString() {
        StringBuilder gameArea = new StringBuilder();

        gameArea.append("-   ".repeat(WIDTH));
        gameArea.append("\n");

        String temp = gameArea.toString();
        gameArea.append(temp.repeat(HEIGHT));

        return gameArea.toString();
    }
}
