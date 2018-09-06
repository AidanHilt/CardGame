package bases;

import java.util.ArrayList;

public abstract class Card {
	public String name = "TEST_NAME";
	protected int energyCost;
	
	private int[] respondCodes;
	
	public void setRespondCodes(int[] codes) {
		respondCodes = codes;
	}
	
	public int[] getRespondCodes() {
		return respondCodes;
	}
	
	public int getEnergyCost() {
		return energyCost;
	}
	
	//This is to get the name of a card
	public String toString() {
		return name;
	}
	
	//This is for an effect that is activated when the card is played
	public abstract void playEffect(Game game, Player player, ArrayList<Card> cards);
	
	public abstract boolean playEffectValid(Game game, Player player, ArrayList<Card> cards);
	
	public abstract void undoPlayEffect(Game game, Player player, ArrayList<Card> cards);
	
	//This is for an effect that is activated of a player's volition
	public abstract void activatedEffect(Game game, Player player, ArrayList<Card> cards);
	
	public abstract boolean activatedEffectValid(Game game, Player player, ArrayList<Card> cards);
	
	public abstract void undoActivatedEffect(Game game, Player player, ArrayList<Card> cards);
	
	//This is for an effect that is activated as a counter
	public abstract void counterEffect(Game game, Player player, ArrayList<Card> cards);
	
	public abstract boolean counterEffectValid(Game game, Player player, ArrayList<Card> cards);
	
	public abstract void undoCounterEffect(Game game, Player player, ArrayList<Card> cards);
}
