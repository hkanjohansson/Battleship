package battleship_game.players;

import battleship_game.ships.*;

import java.util.ArrayList;
import java.util.Random;

public class PlayerAI extends Player {

    int hitDirec; // Which direction to take after hitting the opponents ships
    int hasHit; // Number of hits that help to decide which direction to shoot next
    int[] initialHit; // First hit of a ship
    int[] nextHit; // Next hit of a ship
    int misses; // Number of misses after hitting a ship more than two times. Helps the AI to switch direction

    /*
   Initialize all the various game elements that a player gets when playing a game of battleships.
    */
    public PlayerAI() {
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

        hitDirec = 0;
        hasHit = 0;
        initialHit = new int[2];
        nextHit = new int[2];
        misses = 0;

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

    public void setHasHit() {
        hasHit++;
    }

    public int getHasHit() {
        return hasHit;
    }

    public void setInitialHit(int[] shot) {
        initialHit = shot;
    }

    public void setNextHit(int[] shot) {
        nextHit = shot;
    }

    public void setMisses(int n) {
        if (n == 0) {
            misses = 0;
        } else {
            misses += n;
        }
    }

    /*
      Before a ship is placed it is removed from the list. The placement will
      go on until the ships list is empty.

      First case: Place your ship on an empty area.

      Second case: Check where the preceding ships are placed. If a ship is
      placed where there already is one, then try until the ship is placed
      correctly.

      A random number decides if the ship placement should be horizontal or vertical.

      If 0 -> Horizontal, else vertical.

     */
    @Override
    public void placeShip() {
        Random rand = new Random();

        if (ships.size() == NUMBER_OF_SHIPS) {
            boolean placed = false;

            Ship shipToPlace = ships.remove(0);

            while (!placed) {
                System.out.println(shipToPlace.toString() + " Choose your start coordinates: ");
                int xStart = rand.nextInt(WIDTH);
                int yStart = rand.nextInt(HEIGHT);

                System.out.println("X start: " + xStart);
                System.out.println("Y start: " + yStart);

                int horizontal = rand.nextInt(2);
                int shipSize = shipToPlace.getSize();

                if (horizontal == 0 && xStart + shipSize < 10) {
                    for (int i = 0; i < shipSize; i++) {
                        shipsArea[yStart][xStart + i] = 1;
                        System.out.println(shipsArea[yStart][xStart]);
                        placed = true;
                    }

                } else if (horizontal != 0 && yStart + shipSize < 10) {
                    for (int i = 0; i < shipSize; i++) {
                        shipsArea[yStart + i][xStart] = 1;
                        placed = true;
                    }
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
                int xStart = rand.nextInt(WIDTH);
                int yStart = rand.nextInt(HEIGHT);

                System.out.println("X start: " + xStart);
                System.out.println("Y start: " + yStart);

                System.out.println("Do you want to place horizontal? Then input an integer " +
                        "greater than or equal to 0. " +
                        "If not, provide an integer smaller than 0 to proceed to vertical");

                int horizontal = rand.nextInt(2);
                int shipSize = shipToPlace.getSize();

                if (horizontal == 0 && xStart + shipSize < 10) {
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

                } else if (horizontal != 0 && yStart + shipSize < 10) {

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
      Choose where to fire. If outside the area or where there already has been fired, then try again. Calls the
      helper method fireNext().
     */
    @Override
    public int[] fireWeapon() {
        Random rand = new Random();
        boolean fired = false;

        int x = nextHit[0];
        int y = nextHit[1];

        if (misses >= 2) {
            hasHit = 0;
            misses = 0;
        }

        while (!fired) {
            System.out.println("Provide coordinates where you want to fire: \n");

            if (hasHit >= 1 && misses < 2) {
                nextHit = fireNext(nextHit[0], nextHit[1]);
                x = nextHit[0];
                System.out.println("X-coordinate: " + x);
                y = nextHit[1];
                System.out.println("Y-coordinate: " + y);

                if (x < 0 || y < 0 || x > WIDTH || y > HEIGHT || fireArea[y][x] != 0) {
                    System.out.println("Try shooting where there has not yet been shot.");
                    misses++;
                } else {
                    fireArea[y][x] = 1;
                    fired = true;
                }

            } else {
                x = rand.nextInt(WIDTH);
                System.out.println("X-coordinate: " + x);
                y = rand.nextInt(HEIGHT);
                System.out.println("Y-coordinate: " + y);

                if (fireArea[y][x] != 0) {
                    System.out.println("Try shooting where there has not yet been shot.");
                    misses++;
                } else {
                    fireArea[y][x] = 1;
                    fired = true;
                }
            }
        }

        return new int[]{x, y};
    }

    /*
    Contains two switch statements that decides where to fire next. The first one takes care of the case when the AI
    has hit the opponents ship one time and the second when more than one hit has occurred.
     */
    public int[] fireNext(int x, int y) {
        int[] nextHit = {x, y};
        Random rand = new Random();

        int chooseDirec = rand.nextInt(4); // 0: Left, 1: Right, 2: Down, 3: Up

        if (hasHit == 1) {
            switch (chooseDirec) {
                case 0 -> {
                    nextHit[0]--;
                    hitDirec = 0;
                    if (nextHit[0] < 0) {
                        nextHit[0] += 2;
                        hitDirec = 1;
                        misses++;
                    }
                }
                case 1 -> {
                    nextHit[0]++;
                    hitDirec = 1;
                    if (nextHit[0] >= 10) {
                        nextHit[0] -= 2;
                        hitDirec = 0;
                        misses++;
                    }
                }
                case 2 -> {
                    nextHit[1]--;
                    hitDirec = 2;
                    if (nextHit[1] < 0) {
                        nextHit[1] += 2;
                        hitDirec = 3;
                        misses++;
                    }
                }
                case 3 -> {
                    nextHit[1]++;
                    hitDirec = 3;
                    if (nextHit[1] >= 10) {
                        nextHit[1] -= 2;
                        hitDirec = 2;
                        misses++;
                    }
                }
            }

        } else if (hasHit > 1) { // Continue in the same direction until a miss occur
            switch (hitDirec) {
                case 0 -> {
                    nextHit[0]--;
                    if (nextHit[0] < 0 || fireArea[nextHit[1]][nextHit[0]] != 0) {
                        nextHit = initialHit;
                        nextHit[0]++;
                        hitDirec = 1;
                        misses++;
                    }
                }
                case 1 -> {
                    nextHit[0]++;
                    if (nextHit[0] >= 10 || fireArea[nextHit[1]][nextHit[0]] != 0) {
                        nextHit = initialHit;
                        nextHit[0]--;
                        hitDirec = 0;
                        misses++;
                    }
                }
                case 2 -> {
                    nextHit[1]--;
                    if (nextHit[1] < 0 || fireArea[nextHit[1]][nextHit[0]] != 0) {
                        nextHit = initialHit;
                        nextHit[1]++;
                        hitDirec = 3;
                        misses++;
                    }
                }
                case 3 -> {
                    nextHit[1]++;
                    if (nextHit[1] >= 10 || fireArea[nextHit[1]][nextHit[0]] != 0) {
                        nextHit = initialHit;
                        nextHit[1]--;
                        hitDirec = 2;
                        misses++;
                    }
                }
            }
        }

        this.nextHit = nextHit;
        return this.nextHit;
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
