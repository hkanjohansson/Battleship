package battleship_game.ships;

public class Cruiser extends Ship{

    public Cruiser() {
        super.size = 3;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "This is a cruiser. The cruiser is of size: " + size + ".";
    }
}
