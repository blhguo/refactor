package roulette.roulette;

import java.util.ResourceBundle;

public class BetFactory {
	private static final String QUALIFIED_PREFIX = "roulette.roulette.bets.";
	private static final ResourceBundle BET_PROPERTIES = ResourceBundle.getBundle("roulette/roulette/bets.properties");;
	
	public Bet buildBet(String name){
		try {
			String[] args = getArgs(name);
			Class<?> betClass = Class.forName(QUALIFIED_PREFIX + name);
			return (Bet) (betClass).getConstructor(String.class, Integer.class).newInstance(args[0], Integer.parseInt(args[1]));
		}
		catch(Exception e) {
			return null;
		}
	}
	
	private String[] getArgs(String name) {
		return BET_PROPERTIES.getString(name).split(",");
	}
}