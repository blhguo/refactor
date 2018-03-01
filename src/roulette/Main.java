package roulette;

import roulette.roulette.Gambler;
import roulette.roulette.Game;


/**
 * Plays as many games of roulette until the player runs out of money.
 * 
 * @author Robert C. Duvall
 */
public class Main {
    public static void main (String[] args) {
        Game game = new Game();
        Gambler player = new Gambler("Robert", 1000);

        System.out.println(String.format("Hello %s, let's play %s!\n", player.toString(), game.getName()));
        while (player.isSolvent()) {
            game.play(player);
        }
        System.out.println();
        System.out.println(String.format("\nGoodbye %s, thanks for playing!", player.toString()));
    }
}
