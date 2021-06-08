package battleship_game.players;

import battleship_game.ships.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerHuman extends Player {

    /*
    TODO - Initialize the ships list with all the types of ships

     */
    public PlayerHuman() {
        ships = new ArrayList<>();
        ships.add(new Carrier());
        ships.add(new Battleship());
        ships.add(new Cruiser());
        ships.add(new Submarine());
        ships.add(new Destroyer());

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
        boolean available = true;
        boolean placed = false;


        /*
        TODO - Set all the coordinates in this class
             - Check for available coordinates
             - Fix so that negative coordinates cannot be chosen
                (Generate an error message in the beginning of the method?)
             - If an occupied coordinate is chosen, start all over with the placement
         */

        while (!placed) {
            System.out.println("Choose your start coordinates");
            int xStart = in.nextInt();
            int yStart = in.nextInt();
            s.setXStart(xStart);
            s.setYStart(yStart);

            System.out.println("Do you want to place horizontal? Then input an integer greater than 0. " +
                    "If not, input 0 (or a smaller integer) to proceed to vertical");

            int hori = in.nextInt();
            int shipSize = s.getSize();

            if (hori > 0 && s.getXCoordinate()[0] + shipSize <= 10) {


                for (int i = 0; i < ships.size(); i++) {
                    ArrayList<int[]> checkAvailable = ships.get(i).getShipCoordinates();

                    for (int j = 0; j < checkAvailable.size(); j++) {
                        if (xStart + j != checkAvailable.get(i)[0] &&
                                yStart != checkAvailable.get(i)[1]) {
                            available = true;
                        } else {
                            available = false;
                            System.out.println("This spot is occupied. Try placing your ship correctly.");
                        }
                    }

                }

                if (available) {
                    s.setXEnd(shipSize);
                    totalHealth += s.getSize();
                    placed = true;
                }

            } else if ( hori <= 0 && s.getYCoordinate()[0] + shipSize <= 10){

                for (int i = 0; i < ships.size(); i++) {
                    ArrayList<int[]> checkAvailable = ships.get(i).getShipCoordinates();

                    for (int j = 0; j < checkAvailable.size(); j++) {
                        if (xStart != checkAvailable.get(i)[0] &&
                                yStart + j != checkAvailable.get(i)[1]) {
                            available = true;
                        } else {
                            available = false;
                            System.out.println("This spot is occupied. Try placing your ship correctly.");
                        }
                    }

                }

                if (available) {
                    s.setYEnd(shipSize);
                    totalHealth += s.getSize();
                    placed = true;
                }

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
