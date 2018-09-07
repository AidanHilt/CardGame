package bases;

import java.util.ArrayList;

public abstract class Monster extends Card {
	protected int attack;
	
	public int getAttack() {
		//TODO Add attack bonuses and penalties
		return attack;
	}
	
	private int life;
	
	private ArrayList<Integer> lifeChanges = new ArrayList<Integer>();
	
	public int getLife() {
		int returnVal = life;
		
		for(Integer i : lifeChanges) {
			System.out.println(i.intValue());
			returnVal -= i.intValue();
		}
		
		return returnVal;
	}
	
	public void affectLifeTotal(int value) {
		lifeChanges.add(new Integer(value));
		System.out.println("Affected total!");
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
