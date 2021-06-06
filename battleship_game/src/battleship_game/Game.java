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
    private int numberOfShips;
    private boolean ai;

    public Game(boolean ai) {
        this.width = 10;
        this.height = 10;
        this.numberOfShips = 5;
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
    public String toString() {
        StringBuilder gameArea = new StringBuilder();

        for (int i = 0; i < width; i++) {
            gameArea.append("-   ");
        }
        gameArea.append("\n");

        String temp = gameArea.toString();

        for (int i = 0; i < height; i++) {
            gameArea.append(temp);
        }
        return gameArea.toString();
    }
}
