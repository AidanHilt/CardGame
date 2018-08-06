package bases;

import java.util.ArrayList;

public abstract class GameManager {
	protected Player player;

	public abstract Card selectCard(ArrayList<Card> cards, Game game);
	
	public abstract void turnSelection(Game game);

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
