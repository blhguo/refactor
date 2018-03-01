package roulette.roulette.bets;

import roulette.roulette.Bet;
import roulette.roulette.Wheel;
import roulette.util.ConsoleReader;


public class ThreeConsecutive extends Bet {
    private int myStart;

    public ThreeConsecutive (String description, int odds) {
        super(description, odds);
    }

    /**
     * @see Bet#place()
     */
    @Override
    public void place () {
        myStart = ConsoleReader.promptRange("Enter first of three consecutive numbers", 1, 34);
    }

    /**
     * @see Bet#isMade(String, Wheel)
     */
    @Override
    public boolean isMade (Wheel wheel) {
        return (myStart != 0 && myStart <= wheel.getNumber() && wheel.getNumber() < myStart + 3);
    }
}
