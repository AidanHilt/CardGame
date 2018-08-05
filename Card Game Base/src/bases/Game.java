package bases;

import java.util.ArrayList;

public class Game {
	public Player player1;
	public Player player2;
	
	public int energyTotal = 0;
	public int turnCount = 0;
	
	public ArrayList<Card> player1Side = new ArrayList<Card>();
	public ArrayList<Card> player2Side = new ArrayList<Card>();
	
	public ArrayList<int[]> eventLog = new ArrayList<int[]>();
	
	//Utility methods called during game running
	public boolean affectEnergyTotal(int cost) {

		boolean returnVal;
		if(cost < energyTotal) {
			energyTotal -= cost;
			returnVal = true;
		}else {
			returnVal = false;
		}
		
		return returnVal;
	}

	public void addCardToField(Card card, Player player) {
		if(player == player1) {
			player1Side.add(card);
		}
		else if(player == player2) {
			player2Side.add(card);
		}
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
