package battleship_game;

import battleship_game.players.Player;
import battleship_game.ships.Ship;

import java.util.Iterator;
import java.lang.StringBuilder;

/*
TODO - Add all ships to a list
TODO - Make a player class

 */
public class Game implements GameInterface {
    private int width;
    private int height;
    private boolean ai; // Initialize the game with an AI player or a human player 2

    public Game(boolean ai) {
        this.width = 10;
        this.height = 10;
        this.ai = ai;
    }


    @Override
    public Iterator<Ship> shipIter() {
        return null;
    }

    @Override
    public void addPlayer(Player p) {

    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }


    @Override
    public String toString() {
        return null;
    }
}
