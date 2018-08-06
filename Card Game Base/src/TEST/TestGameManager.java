package TEST;

import java.util.ArrayList;
import java.util.Scanner;

import bases.Card;
import bases.Game;
import bases.GameManager;
import bases.Player;

public class TestGameManager extends GameManager {
	
	public TestGameManager(Player player) {
		this.setPlayer(player);
	}
	
	Scanner scan = new Scanner(System.in);

	@Override
	public Card selectCard(ArrayList<Card> cards, Game game) {
		for(Card c: cards) {
			System.out.println(c.name);
		}
		
		System.out.println("Select the index of the card you wish to use");
		
		int cardIndex = scan.nextInt();
		
		return cards.get(cardIndex);

	}

	@Override
	public void turnSelection(Game game) {
		boolean wantQuit = false;
		
		System.out.println("Waiting for input");
		while(! wantQuit) {	
			Scanner scan = new Scanner(System.in);
			String s = "";
			if(scan.hasNext()) {
				s = scan.nextLine();
				if(s.equals("play")) {
					System.out.println("Enter index of desired card");
					int index = scan.nextInt();
					if(index < player.hand.size()) {
						player.playCard(player.hand.get(index), game);
					}else {
						System.out.println("Invalid index!");
					}
					System.out.println("Waiting for input");
				}
				else if(s.equals("show")) {
					for(Card c:player.hand) {
						System.out.println(c.name);
					}
					System.out.println("Waiting for input");
				}
				else if(s.equals("energy")) {
					System.out.println(game.energyTotal);
					System.out.println("Waiting for input");
				}
				else if(s.equals("health")) {
					System.out.println(player.getlifeTotal());
					System.out.println("Waiting for input");
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
					System.out.println("Waiting for input");
				}
			else {
				System.out.println("Invalid input!");
			}
			}
				
		}
		
	}

}