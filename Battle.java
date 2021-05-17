package gameinterfaces;
import java.io.*;
import java.lang.*;
import java.util.*;


public class Battle implements iBattle  {

	Creature c=new Creature() {};
	
	public Battle(Player player, Monster monster) {
		this.player=player;
		this.monster=monster;
	}
	
	Player player;
	Monster monster;

	
	@Override
	public void run() throws FileNotFoundException,IOException {
		
		Scanner input = new Scanner(System.in);
		boolean playersTurn = true;
		
		
		while (player.isAlive() && monster.isAlive()) {
			if (playersTurn) {
				c.prnt("Player hitPoints: " + player.getHitPoints());
				c.prnt("Monster hitPoints: " + monster.getHitPoints());
				boolean correct = false;
				String choice = "";
				
				while (!correct) {
					
					c.prnt("Do you want to attack or heal?");
					choice = input.nextLine();
					c.prnt(choice);
					if (choice.equalsIgnoreCase("attack") || choice.equalsIgnoreCase("heal")) {
						correct = true;
					}
				}

				if (choice.equals("heal")) {
					player.heal();
				} 
				else {
					player.attack(monster);
				}
				playersTurn = false;
			}
				else {
				monster.enrage();
				monster.attack(player);
				playersTurn=true;
			}
			
		}
	}
}

