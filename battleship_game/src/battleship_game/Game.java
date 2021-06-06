package battleship_game;

import java.util.Iterator;

/*
TODO - Add all ships to a list
TODO - Make a player class

 */
public class Game implements GameInterface {

    /*
    TODO - Add a constructor
     */
    private int width;
    private int height;

    public Game() {

    }

    @Override
    public int width() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public Iterator<Ship> shipIter() {
        return null;
    }

    @Override
    public void addShip(Ship s) {

    }
}
