package battleship_game;

import battleship_game.players.Player;
import battleship_game.ships.Ship;

import java.util.Iterator;

public interface GameInterface {
    Iterator<Ship> shipIter();
    void addPlayer(Player p); // Add ship for a player

    String toString(); // Print game area

}
