package battleship_game;

import battleship_game.players.Player;
import battleship_game.players.PlayerHuman;
import battleship_game.ships.Carrier;
import battleship_game.ships.Ship;


public class GameMain {

    public static void main (String[] args)  {
        Game temp = new Game(false);

        temp.playGame();



    }
}
