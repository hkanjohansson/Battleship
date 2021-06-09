package battleship_game.players;

import battleship_game.ships.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerHuman extends Player {

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

        if (ships.size() == NUMBER_OF_SHIPS) {
            Ship shipToPlace = ships.remove(0);

            System.out.println(shipToPlace.toString() + "Choose your start coordinates: ");
            int xStart = in.nextInt();
            int yStart = in.nextInt();
            shipToPlace.setXStart(xStart);
            shipToPlace.setYStart(yStart);

            System.out.println("Do you want to place horizontal? Then input an integer greater than or equal to 0. " +
                    "If not, provide an integer smaller than 0 to proceed to vertical");

            int hori = in.nextInt();
            int shipSize = shipToPlace.getSize();

            if (hori >= 0 && shipToPlace.getXCoordinate()[0] + shipSize <= 10 && yStart < 10) {
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

            totalHealth += shipToPlace.getSize();

        }

        while (ships.size() < NUMBER_OF_SHIPS && ships.size() > 0) {
            System.out.println(toString());

            Ship shipToPlace = ships.remove(0);

            boolean placed = false;

            while (!placed) {

                boolean available = true;

                System.out.println(shipToPlace.toString() + "Choose your start coordinates: ");
                int xStart = in.nextInt();
                int yStart = in.nextInt();
                s.setXStart(xStart);
                s.setYStart(yStart);

                System.out.println("Do you want to place horizontal? Then input an integer " +
                        "greater than or equal to 0. " +
                        "If not, provide an integer smaller than 0 to proceed to vertical");

                int hori = in.nextInt();
                int shipSize = shipToPlace.getSize();

                if (hori >= 0 && shipToPlace.getXCoordinate()[0] + shipSize <= 10 && yStart < 10) {

                    for (int i = 0; i < shipSize; i++) {
                        if (shipsArea[yStart][xStart + i] != 0) {
                            available = false;
                            System.out.println("Try placing your ship where there is no other.");
                        }
                        break;
                    }

                    if (available) {
                        for (int i = 0; i < shipSize; i++) {
                            shipsArea[yStart][xStart + i] = 1;
                            System.out.println(shipsArea[yStart][xStart]);
                            totalHealth += shipToPlace.getSize();
                            placed = true;
                        }
                    }


                } else if (hori < 0 && shipToPlace.getYCoordinate()[0] + shipSize <= 10 && xStart < 10) {

                    for (int i = 0; i < shipSize; i++) {
                        if (shipsArea[yStart + i][xStart] != 0) {
                            available = false;
                            System.out.println("Try placing your ship where there is no other.");
                        }
                    }

                    if (available) {
                        for (int i = 0; i < shipSize; i++) {
                            shipsArea[yStart + i][xStart] = 1;
                            System.out.println(shipsArea[xStart][yStart]);
                            totalHealth += shipToPlace.getSize();
                            placed = true;
                        }
                    }

                } else {
                    System.out.println("Place your ship within the game area.");
                }

            }
        }

        System.out.println(toString());
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
                if (shipsArea[i][j] != 0) {
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
