package battleship_game.ships;

/*
Placement of ships takes place in the Player class
 */
public abstract class Ship {
    protected int size;


    public abstract int getSize();
    public abstract String toString(); // Print what type of ship and the size of it.
}
