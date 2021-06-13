package battleship_game.ships;

import java.util.ArrayList;

/*
Placement of ships takes place in the Player class

TODO - What will happen when a ship reaches 0 health?

 */
public abstract class Ship {
    protected int size;
    protected int health;
    protected boolean alive;

    public abstract int getSize();
    public abstract String toString();
}
