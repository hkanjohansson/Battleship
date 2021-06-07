package battleship_game;

import battleship_game.players.Player;

import java.util.ArrayList;
import java.util.List;

public class Game implements GameInterface {

    List<Player> players;
    private final int NUMBER_OF_PLAYERS = 2;
    private boolean ai; // Initialize the game with an AI player or a human player 2

    public Game(boolean ai) {
        this.ai = ai;
        this.players = new ArrayList<>();
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
    public void hits() {

    }


    @Override
    public String toString() {
        return null;
    }
}
