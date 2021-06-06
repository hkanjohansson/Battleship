package battleship_game;

import java.util.Iterator;

public interface GameInterface {
    Iterator<Ship> shipIter();
    void addShip(Ship s); // Add ship for a player
    String toString(); // Print game area

}
