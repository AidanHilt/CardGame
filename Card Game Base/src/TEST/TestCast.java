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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean playEffectValid(Game game, Player player, ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void activatedEffect(Game game, Player player, ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean activatedEffectValid(Game game, Player player, ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void counterEffect(Game game, Player player, ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean counterEffectValid(Game game, Player player, ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
