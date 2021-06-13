package battleship_game.ships;

public class Battleship extends Ship{

    public Battleship() {
        super.size = 4;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "This is a battleship. The battleship is of size: " + size + ".";
    }
}
