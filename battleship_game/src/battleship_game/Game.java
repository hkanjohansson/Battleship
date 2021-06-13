package battleship_game;

import battleship_game.players.Player;
import battleship_game.players.PlayerAI;
import battleship_game.players.PlayerHuman;

import java.util.ArrayList;
import java.util.List;


public class Game implements GameInterface {

    List<Player> players;
    /*
    Initialize the game with human and/or AI players.
     */
    public Game(boolean player1_ai, boolean player2_ai) {
        players = new ArrayList<>();

        if (player1_ai) {
            players.add(new PlayerAI());
        } else {
            players.add(new PlayerHuman());
        }

        if (player2_ai && players.size() > 0) {
            players.add(new PlayerAI());
        } else {
            players.add(new PlayerHuman());
        }

        System.out.println("The game has started!");
    }

    /*
    1: Each player are placing their ships
    2: Starts to fire
    3: Print the score
     */
    @Override
    public void playGame() {
        players.get(0).placeShip();
        players.get(1).placeShip();

        hits();

        // When the game has ended the winning player receives bonus
        // points according to the totalHealth left.
        for (Player p : players) {
            if (p.getTotalHealth() > 0) {
                p.setScore(p.getTotalHealth());
            }
        }

        System.out.println("This is the final score for player "+  0 + ": " + players.get(0).getScore());
        System.out.println("This is the final score for player "+  1 + ": " + players.get(1).getScore());
    }
    /*
    The turns are tracked by using modulo 2 to know if it's Player 0 or Player 1.

    First of the case for AI players and then for human players. In the case for AI players we need to track an
    initial hit and a next hit for choosing the direction to fire.
     */
    @Override
    public void hits() {
        int turn = 0;

        while (players.get(0).getTotalHealth() > 0 && players.get(1).getTotalHealth() > 0) {
            int[] shot = players.get(turn % 2).fireWeapon();
            int[][] weaponsFired = players.get(turn % 2).getFireArea();
            int[][] shipsPlacement = players.get((turn + 1) % 2).getShipsArea();


            if (players.get(turn % 2) instanceof PlayerAI && shipsPlacement[shot[1]][shot[0]] != 0) {
                ((PlayerAI) players.get(turn % 2)).setHasHit();

                if (((PlayerAI) players.get(turn % 2)).getHasHit() >= 1) {
                    ((PlayerAI) players.get(turn % 2)).setNextHit(shot);
                } else {
                    ((PlayerAI) players.get(turn % 2)).setInitialHit(shot);
                }

                players.get(turn % 2).setScore(1);
                players.get((turn + 1) % 2).setTotalHealth();
                weaponsFired[shot[1]][shot[0]] = 2; // To indicate a hit for representation in toString()
                System.out.println("Ship hit!");

            } else if (players.get(turn % 2) instanceof PlayerHuman && shipsPlacement[shot[1]][shot[0]] != 0) {
                players.get(turn % 2).setScore(1);
                players.get((turn + 1) % 2).setTotalHealth();
                weaponsFired[shot[1]][shot[0]] = 2; // To indicate a hit for representation in toString()
                System.out.println("Ship hit!");
            }

            System.out.println("Player " + turn % 2 + ": \n" + players.get(turn % 2).toString());
            System.out.println("Player " + turn % 2 + " score after turn " + turn/2 + ": "
                    + players.get(turn % 2).getScore() + "\n");

            turn++;
        }

        if (turn % 2 == 1 && players.get(turn % 2).getTotalHealth() == 1) {
            int[] shot = players.get(turn% 2).fireWeapon();
            int[][] shipsPlacement = players.get((turn + 1) % 2).getShipsArea();

            if (shipsPlacement[shot[1]][shot[0]] != 0) {
                players.get(turn% 2).setScore(1);
                players.get(turn % 2).setTotalHealth();
            }
        }
    }
}
