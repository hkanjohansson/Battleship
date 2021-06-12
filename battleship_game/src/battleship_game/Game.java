package battleship_game;

import battleship_game.players.Player;
import battleship_game.players.PlayerAI;
import battleship_game.players.PlayerHuman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements GameInterface {

    List<Player> players;
    private final int NUMBER_OF_PLAYERS = 2;

    /*
    Should the game be initialized with two human players or one human and one AI? If false then a human player 2
    is added. If true an AI player is added.

    TODO - Add another boolean as argument for adding two ai players
     */
    public Game(boolean ai) {
        this.players = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            if (ai && players.size() > 0) {
                addPlayer(new PlayerAI());
            } else {
                addPlayer(new PlayerHuman());
            }
        }

        System.out.println("The game has started!");
    }


    @Override
    public void addPlayer(Player p) {
        if (players.size() < NUMBER_OF_PLAYERS) {
            players.add(p);
        } else {
            throw new IllegalArgumentException("No more than two players is allowed.");
        }
    }

    /*
    TODO - Clean up code
    TODO - Keep all the scores in a toString method
     */

    @Override
    public void playGame() {

        players.get(0).placeShip();
        players.get(1).placeShip();

        hits();

        for (Player p : players) {
            if (p.getTotalHealth() > 0) {
                p.setScore(p.getTotalHealth()); // When the game has ended the winning player receives bonus
                // points according to the totalHealth left.
            }

            System.out.println("This is the final score: " + p.getScore());
        }

    }

    @Override
    public void hits() {
        int turn = 0;
        Random rand = new Random();

        while (players.get(0).getTotalHealth() > 0 && players.get(1).getTotalHealth() > 0) {
            int[] shot = players.get(turn % 2).fireWeapon();
            int[][] weaponsFired = players.get(turn % 2).getFireArea();
            int[][] shipsPlacement = players.get((turn + 1) % 2).getShipsArea();

            // TODO - Fix error when AI indicates a hit when it is a miss
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

            }

            else if (players.get(turn % 2) instanceof PlayerAI &&
                    ((PlayerAI) players.get(turn % 2)).getHasHit() > 1 ) {

                ((PlayerAI) players.get(turn % 2)).setMisses(1); // TODO - Should this be included?

            }

            else if (players.get(turn % 2) instanceof PlayerHuman && shipsPlacement[shot[1]][shot[0]] != 0) {

                players.get(turn % 2).setScore(1);
                players.get((turn + 1) % 2).setTotalHealth();
                weaponsFired[shot[1]][shot[0]] = 2; // To indicate a hit for representation in toString()
                System.out.println("Ship hit!");

            }

            System.out.println("Player " + turn % 2 + ": \n" + players.get(turn % 2).toString());
            System.out.println("Player " + turn % 2 + ": " + players.get(turn % 2).getScore());

            turn++;
        }

        // Player 2 will have a chance to even out the score.
        // TODO - Add case for the AI player here
        if (turn % 2 == 1 && players.get(turn % 2).getTotalHealth() == 1) {
            int[] shot = players.get(turn % 2).fireWeapon();
            int[][] shipsPlacement = players.get(turn % 2).getShipsArea();

            if (shipsPlacement[shot[1]][shot[0]] != 0) {
                players.get(turn + 1 % 2).setScore(1);
                players.get(turn % 2).setTotalHealth();
                System.out.println("Player " + turn + 1 % 2 + ": " + players.get(turn + 1 % 2).getScore());
            }
        }
    }

    /*
    TODO - Scoreboard representation
     */
    @Override
    public String toString() {
        return null;
    }
}
