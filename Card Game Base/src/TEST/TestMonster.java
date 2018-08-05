package TEST;

import bases.Card;
import bases.Game;
import bases.Monster;
import bases.Player;

public class TestMonster extends Monster {

	@Override
	public void playEffect(Game game, Player player, Card... cards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean playEffectValid(Game game, Player player, Card... cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void activatedEffect(Game game, Player player, Card... cards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean activatedEffectValid(Game game, Player player, Card... cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void counterEffect(Game game, Player player, Card... cards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean counterEffectValid(Game game, Player player, Card... cards) {
		// TODO Auto-generated method stub
		return false;
	}

}
