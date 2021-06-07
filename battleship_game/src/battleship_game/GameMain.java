package battleship_game;

import battleship_game.players.Player;
import battleship_game.players.PlayerHuman;
import battleship_game.ships.Carrier;
import battleship_game.ships.Ship;


public class GameMain {

    public static void main (String[] args)  {
        Game temp = new Game(false);
        Player p = new PlayerHuman();
        Ship carrier = new Carrier();

        System.out.println(temp.toString());
        System.out.println(carrier.toString());

        p.placeShip(carrier);

        for (int i = 0; i < carrier.getShipCoordinates().size(); i++) {
            System.out.println(carrier.getShipCoordinates().get(i)[1]);

        }

    }
}
