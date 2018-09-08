package TEST;

import java.util.ArrayList;

import bases.CONSTANTS;
import bases.Card;
import bases.Cast;
import bases.Game;
import bases.Monster;
import bases.Player;

public class AttackBonusCast extends Cast {
	public AttackBonusCast() {
		int[] codes = {CONSTANTS.NULL_EVENT};
		setRespondCodes(codes);
		name = "Attack Bonus Cast";
		energyCost = 2;
	}

	@Override
	public void playEffect(Game game, Player player, ArrayList<Card> cards) {
		Monster selectedCard = (Monster) player.getGameManager().selectCard(game.getSide(player), game, Monster.class);
		selectedCard.addAttackBonus(3);

	}

	@Override
	public boolean playEffectValid(Game game, Player player, ArrayList<Card> cards) {
		return true;
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
