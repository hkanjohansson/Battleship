package battleship_game;

import java.util.Iterator;

public interface GameInterface {
    int width(); // Width of game area
    int height(); // Height of game area
    Iterator<Ship> shipIter();
    void addShip(Ship s); // Add ship for a player
    String toString(); // Print game area

}
