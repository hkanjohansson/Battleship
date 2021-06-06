package battleship_game;

import battleship_game.players.Player;
import battleship_game.ships.Ship;

import java.util.Iterator;

public interface GameInterface {
    Iterator<Ship> shipIter();
    void addPlayer(Player p); // Add ship for a player
    public int getWidth();
    public int getHeight();
    String toString(); // Print scoreboard at the end of the game

}
