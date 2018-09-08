package bases;

import java.util.ArrayList;

public abstract class GameManager {
	protected Player player;
	
	//TODO Parameterize this so I don't have to cast whenever I need a specific kind of card
	public abstract Card selectCard(ArrayList<Card> cards, Game game, Class<?> cardType);
	
	public abstract void turnSelection(Game game);
	
	public abstract boolean close();

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
