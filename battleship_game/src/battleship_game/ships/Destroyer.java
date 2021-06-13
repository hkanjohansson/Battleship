package battleship_game.ships;

public class Destroyer extends Ship{

    public Destroyer() {
        super.alive = true;
        super.size = 2;
        super.health = 2;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "This is a destroyer. The destroyer is of size: " + size + ".";
    }
}
