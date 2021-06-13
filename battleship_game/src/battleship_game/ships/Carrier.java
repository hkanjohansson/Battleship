package battleship_game.ships;

public class Carrier extends Ship{

    public Carrier() {
        super.size = 5;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "This is a carrier. The carrier is of size: " + size + ".";
    }
}
