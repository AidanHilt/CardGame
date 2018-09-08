package bases;

import java.util.ArrayList;

public class Game {
	public Player player1;
	public Player player2;
	
	private Player playerUp;
	
	public Player getPlayerUp() {
		return playerUp;
	}
	
	public int energyTotal = 0;
	public int turnCount = 0;
	
	public ArrayList<Card> player1Side = new ArrayList<Card>();
	public ArrayList<Card> player2Side = new ArrayList<Card>();
	
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
				
				if(card.playEffectValid(this, player, getSide(player1))) {
					card.playEffect(this, player, getSide(player1));
				}
			}
		}
		else if(player == player2) {
			boolean b = affectEnergyTotal(card.getEnergyCost());
			if(b) {
				player2Side.add(card);
				player2.hand.remove(card);
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
		Player returnVal= new Player("BLANK");
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
				//TODO Keep an eye on this. Might need to modify this method to take both sides as an argument, as it could become dependent on
				// cards on either side of the field.
				if(intInArray(i, c.getRespondCodes()) && c.activatedEffectValid(this, player1, player1Side)) {
					player1Options.add(c);
				}
			}
			
			for(Card c: player2.hand) {
				if(intInArray(i, c.getRespondCodes()) && c.activatedEffectValid(this, player2, player2Side)) {
					player2Options.add(c);
				}
			}
		}
		
		if(player1Options.size() > 0) {
			Card c = player1.getGameManager().selectCard(player1Options, this, Card.class);
			if(c.activatedEffectValid(this, player1, player1Side)) {
				c.activatedEffect(this, player1, player1Side);
			}
		}
		
		if(player2Options.size() > 0) {
			Card c = player2.getGameManager().selectCard(player2Options, this, Card.class);
			if(c.activatedEffectValid(this, player2, player2Side)) {
				c.activatedEffect(this, player2, player2Side);
			}
		}
	}
	
	public boolean intInArray(int i, int[] array) {
		if(array.length > 0) {
			for(int p:array) {
				if(i == p) {
					return true;
				}
			}
		}	
		return false;
	}
		
	
	public ArrayList<Card> getSide(Player p){
		if(p == player1) {
			return player1Side;
		}else if(p == player2) {
			return player2Side;
		}else {
			return new ArrayList<Card>();
		}
	}
	
	//Methods for starting and continuing games
	public void startGame() {
		player1.drawHand();
		player2.drawHand();
		
		energyTotal = CONSTANTS.ENERGY_GAIN_PER_TURN[0];
		
		runGame();
	}
	
	private void runGame() {
		playerUp = player1;
		while(! player1.isDefeated() && ! player2.isDefeated()) {
			playerUp.getGameManager().turnSelection(this);
			turnCount ++;
			energyTotal += CONSTANTS.ENERGY_GAIN_PER_TURN[turnCount];
			playerUp = getOppositePlayer(playerUp);
			
			playerUp.getGameManager().turnSelection(this);
			turnCount ++;
			energyTotal += CONSTANTS.ENERGY_GAIN_PER_TURN[turnCount];
			playerUp = getOppositePlayer(playerUp);
		}
		System.out.println("Out of loop!");
		close();
	}

	private void close() {
		player1.getGameManager().close();
		player2.getGameManager().close();
	}

}
