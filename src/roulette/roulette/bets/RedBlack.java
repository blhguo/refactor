package roulette.roulette.bets;

import roulette.roulette.Bet;
import roulette.roulette.Wheel;
import roulette.util.ConsoleReader;


public class RedBlack extends Bet {
    private String myChoice;

    public RedBlack (String description, int odds) {
        super(description, odds);
    }

    /**
     * @see Bet#place()
     */
    @Override
    public void place () {
        myChoice = ConsoleReader.promptOneOf("Please bet", Wheel.BLACK, Wheel.RED);
    }

    /**
     * @see Bet#isMade(String, Wheel)
     */
    @Override
    public boolean isMade (Wheel wheel) {
        return wheel.getColor().equals(myChoice);
    }
}
