package connectfour.model;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class RandomStarter {

    private Player player1;

    private Player player2;

    public RandomStarter(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        shuffle();
    }

    public void shuffle() {
        Random random = new Random();
        if (random.nextBoolean()) {
            Player tmpPlayer = player1;
            player1 = player2;
            player2 = tmpPlayer;
        }
    }

    public Player getFirstPlayer() {
        return player1;
    }

    public Player getSecondPlayer() {
        return player2;
    }

}
