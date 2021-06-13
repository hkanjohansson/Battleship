package battleship_game;

public interface GameInterface {
    void playGame(); // Keep the game running till one of the players reach 0 health
    void hits(); // Add coordinates and player who got hit
}
