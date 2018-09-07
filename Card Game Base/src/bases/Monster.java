package bases;

import java.util.ArrayList;

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
	
	private int life;
	
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
	
	public void attackMonster(Game game, Monster m) {
		m.affectLifeTotal(getAttack());
	}

}
