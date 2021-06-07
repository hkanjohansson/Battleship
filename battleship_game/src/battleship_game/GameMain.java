package battleship_game;

import battleship_game.ships.Carrier;
import battleship_game.ships.Ship;

public class GameMain {

    public static void main (String[] args)  {
        Game temp = new Game(false);

        Ship carrier = new Carrier(5, 5, 3, 3);


        System.out.println(temp.toString());
        System.out.println(carrier.toString());
    }
}
