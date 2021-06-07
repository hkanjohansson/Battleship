package battleship_game;

import battleship_game.players.Player;


public interface GameInterface {

    void addPlayer(Player p); // Add ship for a player
    void hits(); // Add coordinates and player who got hit


    String toString(); // Print scoreboard at the end of the game

}
