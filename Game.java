package gameinterfaces;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Game {

	Creature c=new Creature() {};
	
	Player player;
	Room[] dungeon = new Room[3];
	
	public Game() throws FileNotFoundException, IOException{
	File file = new File("PlayerInfo.txt");
	Scanner fin = new Scanner(file);

	
	player = new Player(fin.nextLine(),fin.nextLine(),fin.nextInt(),fin.nextInt(),fin.nextInt());
	Monster a = new Monster("Orc", "Covered with green blood",20,5,0);
	Monster b = new Monster("Skeleton","Funny how it moves",40,10,10);
	Monster c = new Monster("Fire Dragon","Spout fire with each breath",100,20,40);
	
	dungeon[0] = new Room(0,"A room with an unbearable smell",a);
	dungeon[1] = new Room(1,"Dark and cold", b);
    dungeon[2] = new TreasureRoom("A giant hall with something shiny on the other end", c, "gold");
	//when player makes it to room 2 the treasure is gold
    fin.close();
	}
	
	
	public void play() throws FileNotFoundException, IOException {
		Scanner s =new Scanner(System.in);
		c.prnt(player.getName()+" "+player.getDescription());
		
		while(player.isAlive()) {
			
			c.prnt("What room do you want to enter 0,1,2?\n");
			
			int room = s.nextInt();
		
			dungeon[room].enter(player);
			
			if(dungeon[0].isComplete()&&dungeon[1].isComplete()&&dungeon[2].isComplete()&&player.isAlive()) {
				
					
				dungeon[room].enter(player);	
				System.exit(0);
				
			}
				
		
		}
		
		
		c.prnt("you died");
	
		c.prnt("Start over?");
		
		String newGame=s.next();
		
		
		if(newGame.equalsIgnoreCase("Yes")){  //if yes call new game
			
			new Game().play();
		
		}else {
			
			System.exit(0);
		}
		
		}
	
	
	
	private String String(int room) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		
		new Game().play(); //calls constructors and objects
		// play calls logic
	

	}

}