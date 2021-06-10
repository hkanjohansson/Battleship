package battleship_game;

import battleship_game.players.Player;


public interface GameInterface {

    void addPlayer(Player p); // Add player to the game. TODO - Or should this be done in the constructor?
    void playGame(); // Keep the game running till one of the players reach 0 health
    void hits(); // Add coordinates and player who got hit


    String toString(); // Print scoreboard at the end of the game

}
