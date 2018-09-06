package TEST;

import bases.Game;
import bases.Player;

public class TestGame {
	
	static Game game = new Game();
	static Player player1 = new Player();
	static Player player2 = new Player();
	
	public static void main(String[] args) {
		player1.deck.add(new TestMonster());
		player1.deck.add(new TestMonster());
		player1.deck.add(new TestMonster());
		player1.deck.add(new TestCast());
		player1.deck.add(new TestCast());
		
		player2.deck.add(new TestMonster());
		player2.deck.add(new TestMonster());
		player2.deck.add(new TestMonster());
		player2.deck.add(new TestCast());
		player2.deck.add(new TestCast());
		
		game.player1 = player1;
		game.player2 = player2;
		
		game.player1GameManager = new TestGameManager(player1);
		game.player2GameManager = new TestGameManager(player2);
		
		game.startGame();
	}

}
