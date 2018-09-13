package TEST;

import java.util.ArrayList;

import bases.Card;
import bases.Game;
import bases.Monster;
import bases.Player;
import bases.CONSTANTS;

public class TestMonster extends Monster {
	public TestMonster() {
		int[] codes = {CONSTANTS.NULL_EVENT};
		setRespondCodes(codes);
		attack = 1;
		life = 3;
	}
	
	@Override
	public void playEffect(Game game, Player player, ArrayList<Card> cards) {
	}

	@Override
	public boolean playEffectValid(Game game, Player player, ArrayList<Card> cards) {
		return false;
	}

	@Override
	public void activatedEffect(Game game, Player player, ArrayList<Card> cards) {
		player.playCard(this, game);
	}

	@Override
	public boolean activatedEffectValid(Game game, Player player, ArrayList<Card> cards) {
		if(game.getPlayerUp() == player) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void counterEffect(Game game, Player player, ArrayList<Card> cards) {
		
	}

	@Override
	public boolean counterEffectValid(Game game, Player player, ArrayList<Card> cards) {
		return false;
	}

	@Override
	public void undoPlayEffect(Game game, Player player, ArrayList<Card> cards) {
		
		
	}

	@Override
	public void undoActivatedEffect(Game game, Player player, ArrayList<Card> cards) {
		
		
	}

	@Override
	public void undoCounterEffect(Game game, Player player, ArrayList<Card> cards) {
		
		
	}

}
