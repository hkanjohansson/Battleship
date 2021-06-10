package battleship_game;

import battleship_game.players.Player;
import battleship_game.players.PlayerAI;
import battleship_game.players.PlayerHuman;

import java.util.ArrayList;
import java.util.List;

public class Game implements GameInterface {

    List<Player> players;
    private final int NUMBER_OF_PLAYERS = 2;

    /*
    Should the game be initialized with two human players or one human and one AI? If false then a human player 2
    is added. If true an AI player is added.
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

    @Override
    public void playGame() {
        Player p1 = players.get(0);
        Player p2 = players.get(1);


        p1.placeShip();
        p2.placeShip();

        int p1Health = p1.getTotalHealth();
        int p2Health = p2.getTotalHealth();

        int turn = 0;

        System.out.println(p1Health);
        System.out.println(p2Health);


        while (p1Health > 0 && p2Health > 0) {
            int[] shot = players.get(turn % 2).fireWeapon();

            //int[][] weaponsFired = players.get(turn % 2).getFireArea();
            int[][] shipsPlacement = players.get((turn + 1) % 2).getShipsArea();

            if (shipsPlacement[shot[1]][shot[0]] != 0) {
                players.get(turn % 2).setScore(1);
                players.get((turn + 1) % 2).setTotalHealth();
                System.out.println("Ship hit!");
            }

            System.out.println("Player " + turn % 2 + ": " + players.get(turn % 2).getScore());
            turn++;
        }

        // Player 2 will have a chance to even out the score.
        if (turn % 2 == 0) {
            int[] shot = players.get(turn + 1 % 2).fireWeapon();
            int[][] shipsPlacement = players.get(turn % 2).getShipsArea();

            if (shipsPlacement[shot[1]][shot[0]] != 0) {
                players.get(turn + 1 % 2).setScore(1);
                players.get(turn % 2).setTotalHealth();
                System.out.println("Player " + turn + 1 % 2 + ": " + players.get(turn + 1 % 2).getScore());
            }
        }

        for (Player p : players) {
            if (p.getTotalHealth() > 0 ) {
                p.setScore(p.getTotalHealth());
            }
        }

    }

    @Override
    public void hits() {

        int[][] temp = players.get(0).getFireArea();

        players.get(0).fireWeapon();
        for (int i = 0; i < players.get(0).getFireArea().length; i++) {
            for (int j = 0; j < players.get(0).getFireArea().length; j++) {


                /*
                TODO - If p1 fire area[i][j] corresponds to p2 ship area[i][j] -> hit
                        and vice versa.

                TODO - Increase score

                TODO - What type of ship
                 */
            }

        }
    }

    /*
    Scoreboard representation
     */
    @Override
    public String toString() {
        return null;
    }
}
