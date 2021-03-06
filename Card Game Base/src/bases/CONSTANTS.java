package bases;

public class CONSTANTS {
	
	public static final int STARTING_HAND_SIZE = 5;
	//TODO Turn this into a method so that the game could theoretically go on forever.
	public static final int[] ENERGY_GAIN_PER_TURN = {3, 3, 5, 5, 7, 7, 9};
	
	//Event codes: All of these codes are used to indicate what type of event happened
	public static final int NULL_EVENT = -1;
	public static final int CARD_PLAYED = 0;
	public static final int MONSTER_PLAYED = 1;
	public static final int CAST_PLAYED = 2;
	public static final int ENERGY_DRAWN = 3;
	public static final int MONSTER_ATTACKED = 4;
	public static final int CARD_REMOVED = 5;
	public static final int CAST_REMOVED = 6;
	public static final int MONSTER_REMOVED = 7;
	public static final int MONSTER_KILLED_IN_BATTLE = 8;
	
}
