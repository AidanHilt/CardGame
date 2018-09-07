package TEST;

import bases.Game;
import bases.Player;

public class TestGame {
	
	static Game game = new Game();
	static Player player1 = new Player("Player 1");
	static Player player2 = new Player("Player 2");
	
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
		
		player1.setGameManager(new TestGameManager(player1));
		player2.setGameManager(new TestGameManager(player2));
		
		game.startGame();
	}

}
