package bases;

import java.util.ArrayList;

public class BlankCard extends Card {

	@Override
	public void playEffect(Game game, Player player, ArrayList<Card> cards) {
		

	}

	@Override
	public boolean playEffectValid(Game game, Player player, ArrayList<Card> cards) {
		
		return false;
	}

	@Override
	public void undoPlayEffect(Game game, Player player, ArrayList<Card> cards) {
		

	}

	@Override
	public void activatedEffect(Game game, Player player, ArrayList<Card> cards) {
		

	}

	@Override
	public boolean activatedEffectValid(Game game, Player player, ArrayList<Card> cards) {
		
		return false;
	}

	@Override
	public void undoActivatedEffect(Game game, Player player, ArrayList<Card> cards) {
		

	}

	@Override
	public void counterEffect(Game game, Player player, ArrayList<Card> cards) {
		

	}

	@Override
	public boolean counterEffectValid(Game game, Player player, ArrayList<Card> cards) {
		
		return false;
	}

	@Override
	public void undoCounterEffect(Game game, Player player, ArrayList<Card> cards) {
		

	}

}
