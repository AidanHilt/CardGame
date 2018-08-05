package bases;

public abstract class Card {
	public String name = "TEST_NAME";
	protected int energyCost;
	
	private int[] respondCodes;
	
	public int[] getRespondCodes() {
		return respondCodes;
	}
	
	public int getEnergyCost() {
		return energyCost;
	}
	//This is for an effect that is activated when the card is played
	public abstract void playEffect(Game game, Player player, Card...cards);
	
	public abstract boolean playEffectValid(Game game, Player player, Card...cards);
	
	//This is for an effect that is activated of a player's volition
	public abstract void activatedEffect(Game game, Player player, Card...cards);
	
	public abstract boolean activatedEffectValid(Game game, Player player, Card...cards);
	
	//This is for an effect that is activated as a counter
	public abstract void counterEffect(Game game, Player player, Card...cards);
	
	public abstract boolean counterEffectValid(Game game, Player player, Card...cards);
}
