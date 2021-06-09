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


    /*
      Before a ship is placed it is removed from the list. The placement will
      go on until the list is empty.

      First case: Place your ship on an empty area.

      Second case: Check where the preceding ships are placed. If a ship is
      placed where there already is one, then try until the ship is placed
      correctly.

     */
    @Override
    public void placeShip() {

        Scanner in = new Scanner(System.in);

        if (ships.size() == NUMBER_OF_SHIPS) {
            Ship shipToPlace = ships.remove(0);

            System.out.println(shipToPlace.toString() + "Choose your start coordinates: ");
            int xStart = in.nextInt();
            int yStart = in.nextInt();

            System.out.println("Do you want to place horizontal? Then input an integer greater than or equal to 0. " +
                    "If not, provide an integer smaller than 0 to proceed to vertical");

            int horizontal = in.nextInt();
            int shipSize = shipToPlace.getSize();

            if (horizontal >= 0 && shipToPlace.getXCoordinate()[0] + shipSize <= 10 && yStart < 10) {
                for (int i = 0; i < shipSize; i++) {
                    shipsArea[yStart][xStart + i] = 1;
                    System.out.println(shipsArea[yStart][xStart]);
                }

            } else if (horizontal < 0 && shipToPlace.getYCoordinate()[0] + shipSize <= 10 && xStart < 10) {
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


                System.out.println("Do you want to place horizontal? Then input an integer " +
                        "greater than or equal to 0. " +
                        "If not, provide an integer smaller than 0 to proceed to vertical");

                int horizontal = in.nextInt();
                int shipSize = shipToPlace.getSize();

                if (horizontal >= 0 && shipToPlace.getXCoordinate()[0] + shipSize <= 10 && yStart < 10) {
                    for (int i = 0; i < shipSize; i++) {
                        if (shipsArea[yStart][xStart + i] != 0) {
                            available = false;
                            System.out.println("Try placing your ship where there is no other.");
                            break;
                        }
                    }

                    if (available) {
                        for (int i = 0; i < shipSize; i++) {
                            shipsArea[yStart][xStart + i] = 1;
                            System.out.println(shipsArea[yStart][xStart]);
                            totalHealth += shipToPlace.getSize();
                            placed = true;
                        }
                    }


                } else if (horizontal < 0 && shipToPlace.getYCoordinate()[0] + shipSize <= 10 && xStart < 10) {

                    for (int i = 0; i < shipSize; i++) {
                        if (shipsArea[yStart + i][xStart] != 0) {
                            available = false;
                            System.out.println("Try placing your ship where there is no other.");
                            break;
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

    /*
      Choose where to fire. If outside the area or where there already has been fired, then try again.
     */
    @Override
    public void fireWeapon() {
        Scanner in = new Scanner(System.in);
        boolean fired = false;

        while (!fired) {
            System.out.println("Provide coordinates where you want to fire: ");
            int x = in.nextInt();
            int y = in.nextInt();

            if (x < 0 || y < 0 || x > WIDTH || y > HEIGHT || fireArea[y][x] != 0) {
                System.out.println("Try shooting within the area at the next try.");
            } else {
                fireArea[y][x] = 1;
                fired = true;
            }
        }

        System.out.println(toString());

    }

    /*
    Print of the areas where ship has been placed and weapons has been fired.
     */
    @Override
    public String toString() {
        StringBuilder shipAreaString = new StringBuilder();
        StringBuilder fireAreaString = new StringBuilder();

        shipAreaString.append("Ships:\n");
        fireAreaString.append("Fire:\n");
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

        for (int i = 0; i < WIDTH; i++) {
            fireAreaString.append("{ ");
            for (int j = 0; j < HEIGHT; j++) {
                if (fireArea[i][j] != 0) {
                    fireAreaString.append("X ");
                } else {
                    fireAreaString.append(fireArea[i][j] + " ");
                }

            }

            fireAreaString.append("}\n");
        }

        return shipAreaString.toString() + " " + fireAreaString.toString();
    }
}
