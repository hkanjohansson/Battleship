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
    Should the game be initialized with two human players or one human and one AI?
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

        System.out.println("The game is started!");
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

        int turn = 0;

        while (p1.getTotalHealth() > 0 && p2.getTotalHealth() > 0) {
            
        }

    }

    @Override
    public void hits() {

    }


    @Override
    public String toString() {
        return null;
    }
}
