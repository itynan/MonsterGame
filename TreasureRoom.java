package gameinterfaces;

import java.io.*;
import java.lang.*;
import java.util.*;


public class TreasureRoom extends Room implements iTreasureRoom {
	String treasure;
	
	//Creature c = new Creature() {};
	
	public TreasureRoom(String description, Monster monster, String treasure) {
		super(2, description, monster); //when user gets to index 2 call treasureRoom
		this.treasure = treasure;
	}

	@Override
	public void enter(Player player) throws FileNotFoundException,IOException {
		
			
		super.prnt("This Room is " + super.description + " and has " + super.monster.getName());
			
			if (super.monster.isAlive()) {
				new Battle(player, super.monster).run();
					
				
			}  
			
			else{
				super.prnt("You explored the room and found the hidden treasure");}	
	
	}

}