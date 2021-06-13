package battleship_game.ships;

public class Submarine extends Ship{

    public Submarine() {
        super.alive = true;
        super.size = 3;
        super.health = 3;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "This is a submarine. The submarine is of size: " + size + ".";
    }
}
