package TEST;

import java.util.ArrayList;

import bases.CONSTANTS;
import bases.Card;
import bases.Cast;
import bases.Game;
import bases.Player;

public class TestCast extends Cast {
	public TestCast() {
		int[] codes = {CONSTANTS.NULL_EVENT};
		setRespondCodes(codes);
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
		
		
	}

	@Override
	public boolean activatedEffectValid(Game game, Player player, ArrayList<Card> cards) {
		
		return false;
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
