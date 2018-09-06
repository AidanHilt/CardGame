package bases;

import java.util.ArrayList;

public abstract class Monster extends Card {
	private int attack;
	
	public int getAttack() {
		//TODO Add attack bonuses and penalties
		return attack;
	}
	
	private int life;
	
	private ArrayList<Integer> lifeChanges = new ArrayList<Integer>();
	
	public int getLife() {
		//TODO Add healing and damage
		return life;
	}
	
	public void affectLifeTotal(int value) {
		lifeChanges.add(new Integer(value));
	}
	
	public Monster(){
		name = "TEST_MONSTER";
		energyCost = 1;
	}
	
	public String toString() {
		return name + ", ATK:" + getAttack() + " LIF:" + getLife();
	}
	
	public void attackMonster(Game game, GameManager gm) {
		((Monster) gm.selectCard(game.player2Side, game, Monster.class)).affectLifeTotal(getAttack());
	}

}
