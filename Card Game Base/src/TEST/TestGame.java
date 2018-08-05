package TEST;

import java.util.Scanner;

import bases.Card;
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
		
		game.startGame();
		
		boolean wantQuit = false;
		
		System.out.println("Waiting for input");
		while(! wantQuit) {	
			Scanner scan = new Scanner(System.in);
			String s = "";
			if(scan.hasNextLine()) {
				s = scan.nextLine();
			if(s.equals("play")) {
				System.out.println("Enter index of desired card");
				int index = scan.nextInt();
				if(index < player1.hand.size()) {
					player1.playCard(player1.hand.get(index), game);
				}else {
					System.out.println("Invalid index!");
				}
			}
			else if(s.equals("show")) {
				for(Card c:player1.hand) {
					System.out.println(c.name);
				}
			}
			else if(s.equals("energy")) {
				System.out.println(game.energyTotal);
			}
			else if(s.equals("health")) {
				System.out.println(player1.getlifeTotal());
			}
			else if(s.equals("quit")) {
				wantQuit = true;
				scan.close();
			}
			else if(s.equals("p1side")) {
				for(Card c:game.player1Side) {
					System.out.println(c.name);
				}
			}
			else if(s.equals("p2side")) {
				for(Card c: game.player2Side){
					System.out.println(c.name);
				}
			}
			else {
				System.out.println("Invalid input!");
			}
			System.out.println("Waiting for input");
			
			}
				
		}
	}

}
