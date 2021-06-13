package battleship_game.players;

import battleship_game.ships.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerHuman extends Player {

    /*
    Initialize all the various game elements that a player gets when playing a game of battleships.
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
        score = 0;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int s) {
        score += s;
    }

    @Override
    public int getTotalHealth() {
        return totalHealth;
    }

    @Override
    public void setTotalHealth() {
        totalHealth--;
    }

    @Override
    public int[][] getShipsArea() {
        return shipsArea;
    }

    @Override
    public int[][] getFireArea() {
        return fireArea;
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
            boolean placed = false;

            while (!placed) {
                System.out.println(shipToPlace.toString() + " Choose your start coordinates: ");
                int xStart = in.nextInt();
                int yStart = in.nextInt();

                System.out.println("Do you want to place horizontal? Then input an integer greater than or equal to 0. " +
                        "If not, provide an integer smaller than 0 to proceed to vertical");

                int horizontal = in.nextInt();
                int shipSize = shipToPlace.getSize();
                if (horizontal >= 0 && xStart + shipSize < 10 && yStart < 10) {
                    for (int i = 0; i < shipSize; i++) {
                        shipsArea[yStart][xStart + i] = 1;
                        placed = true;
                    }

                } else if (horizontal < 0 && yStart + shipSize < 10 && xStart < 10) {
                    for (int i = 0; i < shipSize; i++) {
                        shipsArea[yStart + i][xStart] = 1;
                        System.out.println(shipsArea[xStart][yStart]);
                        placed = true;
                    }
                } else {
                    System.out.println("Try placing your ship within the area.");
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

                if (horizontal >= 0 && xStart + shipSize < 10 && yStart < 10) {
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
                        }

                        totalHealth += shipToPlace.getSize();
                        placed = true;
                    }

                } else if (horizontal < 0 && yStart + shipSize < 10 && xStart < 10) {
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
                        }

                        placed = true;
                        totalHealth += shipToPlace.getSize();
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
    public int[] fireWeapon() {
        Scanner in = new Scanner(System.in);
        boolean fired = false;

        int x = 0;
        int y = 0;

        while (!fired) {
            System.out.println("Provide coordinates where you want to fire: ");
            System.out.println("X-coordinate: ");
            x = in.nextInt();
            System.out.println("Y-coordinate: ");
            y = in.nextInt();

            if (x < 0 || y < 0 || x > WIDTH || y > HEIGHT || fireArea[y][x] != 0) {
                System.out.println("Try shooting within the area at the next try.");
            } else {
                fireArea[y][x] = 1;
                fired = true;
            }
        }

        return new int[]{x, y};
    }

    /*
    Print of the areas where ship has been placed and weapons has been fired.
     */
    @Override
    public String toString() {
        StringBuilder playerBuild = new StringBuilder();

        for (int i = 0; i < HEIGHT; i++) {
            playerBuild.append("{ ");
            for (int j = 0; j < WIDTH; j++) {
                if (shipsArea[i][j] != 0) {

                    playerBuild.append("X ");
                } else {

                    playerBuild.append(shipsArea[i][j]).append(" ");
                }
            }

            playerBuild.append("} | ");
            playerBuild.append("{ ");

            for (int j = 0; j < WIDTH; j++) {
                if (fireArea[i][j] == 2) {
                    playerBuild.append("V ");
                } else if (fireArea[i][j] == 1) {
                    playerBuild.append("X ");
                } else {
                    playerBuild.append(fireArea[i][j]).append(" ");
                }
            }
            playerBuild.append("}\n");
        }

        return playerBuild.toString();
    }
}
