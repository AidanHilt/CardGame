package bases;

import java.util.ArrayList;

public class Player {
	public Player(String name) {
		this.name = name;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	private int lifeTotal = 20;
	
	public void setLifeTotal(int change) {
		lifeTotal -= change;
	}
	
	public int getlifeTotal() {
		return lifeTotal;
	}
	
	public ArrayList<Card> hand = new ArrayList<Card>();
	public ArrayList<Card> deck = new ArrayList<Card>();

	public boolean isDefeated() {
		return false;
	}
	
	public void drawCard() {
		hand.add(deck.get(0));
		deck.remove(0);
	}
	
	public void drawHand() {
		int count = CONSTANTS.STARTING_HAND_SIZE;
		while(count >= 1){
			drawCard();
			count --;
		}
	}
	
	public void playCard(Card card, Game game) {
		boolean b = game.addCardToField(card, this);
	}

}
