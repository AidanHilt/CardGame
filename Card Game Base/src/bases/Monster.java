package bases;

public abstract class Monster extends Card {
	public int attack;
	public int life;
	
	public Monster(){
		name = "TEST_MONSTER";
		energyCost = 1;
	}

}
