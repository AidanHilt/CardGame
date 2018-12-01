package TEST;

import java.util.ArrayList;
import java.util.Scanner;

import bases.Card;
import bases.Game;
import bases.GameManager;
import bases.Monster;
import bases.Player;

public class TestGameManager extends GameManager {
	
	public TestGameManager(Player player) {
		this.setPlayer(player);
	}
	
	Scanner scan = new Scanner(System.in);
	
	@Override
	public int selectCard(ArrayList<Card> cards, Game game, Class<?> cardType) {
		for(Card c: cards) {
			System.out.println(c.toString());
		}
		
		System.out.println("Select the index of the card you wish to use, or choose to use none, " + player.getName());
		
		int cardIndex = scan.nextInt();
		
		return cardIndex;
	}

	@Override
	public void turnSelection(Game game) {
		boolean wantQuit = false;
		
		System.out.println("Waiting for input, " + player.getName());
		while(! wantQuit) {	
			String s = "";
			if(scan.hasNext()) {
				s = scan.nextLine();
				if(s.equals("play")) {
					//TODO Make this use the selectCard() method
					int index = player.getGameManager().selectCard(player.hand, game, Card.class);
					if(index < player.hand.size() && index != -1) {
						player.playCard(player.hand.get(index), game);
					}else if(index != -1){
						System.out.println("Invalid index!");
					}
					System.out.println("Waiting for input, " + player.getName());
				}
				else if(s.equals("show")) {
					for(Card c:player.hand) {
						System.out.println(c.name);
					}
					System.out.println("Waiting for input, " + player.getName());
				}
				else if(s.equals("energy")) {
					System.out.println(game.energyTotal);
					System.out.println("Waiting for input, " + player.getName());
				}
				else if(s.equals("health")) {
					System.out.println(player.getlifeTotal());
					System.out.println("Waiting for input, " + player.getName());
				}
				else if(s.equals("quit")) {
					wantQuit = true;
				}
				else if(s.equals("p1side")) {
					for(Card c:game.player1Side) {
						System.out.println(c.toString());
					}
				}
				else if(s.equals("p2side")) {
					for(Card c: game.player2Side){
						System.out.println(c.toString());
					}
					System.out.println("Waiting for input, " + player.getName());
				}
				else if(s.equals("field")) {
					System.out.println("Player 1 side");
					for(Card c:game.player1Side) {
						System.out.println(c.toString());
					}
					System.out.println("Player 2 side");
					for(Card c: game.player2Side){
						System.out.println(c.toString());
					}
					
					System.out.println("Waiting for input, " + player.getName());
				}
				else if(s.equals("attack")) {
					int atkIndex = selectCard(game.getSide(player), game, Monster.class);
					if(atkIndex != -1) {
						System.out.println("Choose target!");
						int defIndex = selectCard(game.getSide(game.getOppositePlayer(player)), game, Monster.class);
						
						if(defIndex != -1) {
							Monster attackMonster = (Monster) game.getSide(player).get(atkIndex);
							Monster defenseMonster = (Monster) game.getSide(game.getOppositePlayer(player)).get(defIndex);
							attackMonster.attackMonster(game, defenseMonster);
						}
						
					}
					
					System.out.println("Waiting for input, " + player.getName());
				}
				else if(s.equals("help")) {
					//TODO Add help item to test game manager
					System.out.println("Write all commands in all lowercase letters");
				}
			else if (! s.equals("")){
				System.out.println("Invalid input, " + player.getName());
				System.out.println(s);
			}
			}
				
		}
		
	}

	@Override
	public boolean close() {
		scan.close();
		return true;
	}

}
