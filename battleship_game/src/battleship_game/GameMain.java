package battleship_game;

import java.util.Scanner;

public class GameMain {

    public static void main (String[] args)  {
        Scanner in = new Scanner(System.in);

        System.out.println("Input something to start the game for two AI players: ");
        in.next();
        Game battleShipsTwoAI = new Game(true, true);
        battleShipsTwoAI.playGame();

        System.out.println("Input something to start the game for one human and one AI player: ");
        in.next();
        Game battleShipsOneAI = new Game(false, true);
        battleShipsOneAI.playGame();

        System.out.println("Input something to start the game for two human players: ");
        in.next();
        Game battleShipsNoAI = new Game(false, true);
        battleShipsNoAI.playGame();
    }
}
