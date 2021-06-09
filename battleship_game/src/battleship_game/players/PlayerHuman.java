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

        shipsArea = new int[WIDTH][HEIGHT];
        fireArea = new int[WIDTH][HEIGHT];

        totalHealth = 0;

        System.out.println("Hej: " + WIDTH);
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





        /*
        TODO - Check for available coordinates
             - Fix so that negative coordinates cannot be chosen
                (Generate an error message in the beginning of the method?)
             - If an occupied coordinate is chosen, start all over with the placement
         */

        if (ships.size() == NUMBER_OF_SHIPS) {
            Ship shipToPlace = ships.remove(0);

            System.out.println(shipToPlace.toString() + "Choose your start coordinates: ");
            int xStart = in.nextInt();
            int yStart = in.nextInt();
            s.setXStart(xStart);
            s.setYStart(yStart);

            System.out.println("Do you want to place horizontal? Then input an integer greater than or equal to 0. " +
                    "If not, provide an integer smaller than 0 to proceed to vertical");

            int hori = in.nextInt();
            int shipSize = s.getSize();

            if (hori >= 0 && shipToPlace.getXCoordinate()[0] + shipSize <= 10 && yStart < 10) {
                shipToPlace.setXEnd(shipSize);

                for (int i = 0; i < shipSize; i++) {
                    shipsArea[yStart][xStart + i] = 1;
                    System.out.println(shipsArea[yStart][xStart]);
                }

            } else if (hori < 0 && shipToPlace.getYCoordinate()[0] + shipSize <= 10 && xStart < 10) {
                for (int i = 0; i < shipSize; i++) {
                    shipsArea[yStart + i][xStart] = 1;
                    System.out.println(shipsArea[xStart][yStart]);
                }
            }

        }

        /*
        while (ships.size() > 0) {
            Ship shipToPlace = ships.remove(0);
            boolean placed = false;
            boolean available = false;

            System.out.println(shipToPlace.toString() + " Place your ship.");



            while (!placed) {

                for (int i = 0; i < WIDTH; i++) {
                    for (int j = 0; j < HEIGHT; j++) {
                        if ()
                    }
                }
            }
        }

        */

        /*
        while (!placed) {







                for (int i = 0; i < shipsPlaced.size(); i++) {
                    ArrayList<int[]> checkAvailable = shipsPlaced.get(i).getShipCoordinates();


                    for (int j = 0; j < checkAvailable.size(); j++) {
                        System.out.println("hej");
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
                    shipsPlaced.add(s);
                }

            } else if ( hori <= 0 && s.getYCoordinate()[0] + shipSize <= 10){

                for (int i = 0; i < shipsPlaced.size(); i++) {
                    ArrayList<int[]> checkAvailable = shipsPlaced.get(i).getShipCoordinates();

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
                    shipsPlaced.add(s);
                }

            } else {
                System.out.println("Try placing your ship correctly");
            }

        }
        */
        System.out.println("Hej");
    }

    @Override
    public void fireWeapon(int x, int y) {

    }

    @Override
    public String toString() {
        StringBuilder shipAreaString = new StringBuilder();
        StringBuilder fireAreaString = new StringBuilder();

        for (int i = 0; i < WIDTH; i++) {
            shipAreaString.append("{ ");
            for (int j = 0; j < HEIGHT; j++) {
                if (shipsArea[i][j] != 0){
                    shipAreaString.append("X ");
                } else {
                    shipAreaString.append(shipsArea[i][j] + " ");
                }

            }
            shipAreaString.append("}\n");
        }
        return shipAreaString.toString();
    }
}
