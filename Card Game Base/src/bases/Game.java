package bases;

import java.util.ArrayList;

public class Game {
	public Player player1;
	public Player player2;
	
	public int energyTotal = 0;
	public int turnCount = 0;
	
	public ArrayList<Card> player1Side = new ArrayList<Card>();
	public ArrayList<Card> player2Side = new ArrayList<Card>();
	
	public GameManager player1GameManager;
	public GameManager player2GameManager;
	
	public ArrayList<int[]> eventLog = new ArrayList<int[]>();
	
	//Utility methods called during game running
	public boolean affectEnergyTotal(int cost) {

		boolean returnVal;
		if(cost <= energyTotal) {
			energyTotal -= cost;
			returnVal = true;
		}else {
			returnVal = false;
		}
		return returnVal;
	}

	public boolean addCardToField(Card card, Player player) {
		boolean returnVal = false;
		if(player == player1) {
			boolean b = affectEnergyTotal(card.getEnergyCost());
			if(b) {
				player1Side.add(card);
				player1.hand.remove(card);
				int[] codes = {CONSTANTS.NULL_EVENT};
				if(card instanceof Monster) {
					int[] val = {CONSTANTS.CARD_PLAYED, CONSTANTS.MONSTER_PLAYED};
					codes = val;
				}
				else if(card instanceof Cast) {
					int[] val = {CONSTANTS.CARD_PLAYED, CONSTANTS.CAST_PLAYED};
					codes = val;
				}
				
				addEventToQueue(codes);
				returnVal = true;
			}
		}
		else if(player == player2) {
			boolean b = affectEnergyTotal(card.getEnergyCost());
			if(b) {
				player2Side.add(card);
				int[] codes = {CONSTANTS.NULL_EVENT};
				if(card instanceof Monster) {
					int[] val = {CONSTANTS.CARD_PLAYED, CONSTANTS.MONSTER_PLAYED};
					codes = val;
				}
				else if(card instanceof Cast) {
					int[] val = {CONSTANTS.CARD_PLAYED, CONSTANTS.CAST_PLAYED};
					codes = val;
				}
				
				addEventToQueue(codes);
				returnVal = true;
			}
		}
		
		return returnVal;
	}

	public Player getOppositePlayer(Player player) {
		Player returnVal= new Player();
		if(player.equals(player1)) {
			returnVal = player2;
		}
		else if(player.equals(player2)) {
			returnVal = player1;
		}
		
		return returnVal;
	}

	public void addEventToQueue(int[] codes) {
		ArrayList<Card> player1Options = new ArrayList<Card>();
		ArrayList<Card> player2Options = new ArrayList<Card>();
		
		eventLog.add(codes);
		
		for(int i : codes) {
			for(Card c : player1.hand) {
				if(intInArray(i, c.getRespondCodes())) {
					player1Options.add(c);
				}
			}
		}
		
		if(player1Options.size() > 0) {
			Card c = player1GameManager.selectCard(player1Options, this);
			if(c.activatedEffectValid(this, player1, player1Side)) {
				c.activatedEffect(this, player1, player1Side);
			}
		}
	}
	
	public boolean intInArray(int i, int[] array) {
		for(int p:array) {
			if(i == p) {
				return true;
			}
		}
		
		return false;
	}
	
	//Methods for starting and continuing games
	public void startGame() {
		player1.drawHand();
		player2.drawHand();
		
		energyTotal = CONSTANTS.ENERGY_GAIN_PER_TURN[0];
	}


}
