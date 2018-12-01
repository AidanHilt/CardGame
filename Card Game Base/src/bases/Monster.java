package bases;

import java.util.ArrayList;
import bases.CONSTANTS;

public abstract class Monster extends Card {
	protected int attack;
	
	private ArrayList<Integer> attackBonuses = new ArrayList<Integer>();
	
	public void addAttackBonus(int bonus) {
		attackBonuses.add(new Integer(bonus));
	}
	
	public void removeAttackBonus(int bonus) {
		attackBonuses.remove(new Integer(bonus));
	}
	
	public int getAttack() {
		int returnVal = attack;
		
		for(Integer i : attackBonuses) {
			returnVal += i.intValue();
		}
		
		return returnVal;
	}
	
	protected int life;
	
	private ArrayList<Integer> lifeChanges = new ArrayList<Integer>();
	
	public int getLife() {
		int returnVal = life;
		
		for(Integer i : lifeChanges) {
			returnVal -= i.intValue();
		}
		
		return returnVal;
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
	
	//Note: This can be overriden if the monster is meant to have a different condition for staying alive
	//TODO Keep an eye on this, and add new arguments as needed
	public boolean canLive() {
		if(getLife() > 0) return true;
		return false;
	}
	
	public void attackMonster(Game game, Monster m) {
		m.affectLifeTotal(getAttack());
		
		if(! m.canLive()) { 
			game.removeCard(m); 
			int[] codes = {CONSTANTS.MONSTER_KILLED_IN_BATTLE, CONSTANTS.MONSTER_REMOVED};
			game.addEventToQueue(codes);
		}
		if(! this.canLive()) { 
			game.removeCard(this);
			int[] codes = {CONSTANTS.MONSTER_KILLED_IN_BATTLE, CONSTANTS.MONSTER_REMOVED};
			game.addEventToQueue(codes);
		}
	}

}
