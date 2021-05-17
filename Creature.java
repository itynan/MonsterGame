package gameinterfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Creature implements iCreature {
	
	private String name;
	private String description;
	private int hitPoints;
	private int damage;
	
	public Creature() {
	String name="";
	String description="";
	int hitPoints=0;
	int damage=0;
	}
	public Creature(String name, String description, int hitPoints, int damage) {
		this.name = name;
		this.description = description;
		this.hitPoints = hitPoints;
		this.damage = damage;
		this.room = null;
	}
	
	iRoom room=null;
	
	
	
	public String getName() {	
		return this.name;
	}



	
	public String getDescription() {
		return this.description;
	}



	public int getHitPoints() {
		return this.hitPoints;
	}



	
	public int getDamage() {
		return this.damage;
	}



	
	public iRoom getRoom() {
		return this.room;
	}


	public void setHitPoints(int HP) {
		
		this.hitPoints=HP;
	}



	
	public void setDamage(int dmg) {
		
		this.damage=dmg;
	}



	
	public void setRoom(iRoom rm) {
		this.room=rm;
		
	}
	

	public void attack(Creature creature)throws FileNotFoundException, IOException {
		creature.takeDamage(damage);
		prnt(name+ " attacks target "+creature.getName()
		+ " dealing "+ damage+ " damage");
		
	}


	public void takeDamage(int damage) {
		
		this.hitPoints-=damage;
		
		if(this.hitPoints<0) {
			this.hitPoints=0;
		}
	
	}

	
	public boolean isAlive() {
		
		if(hitPoints>0){
			return true;
		}
		
		return false;
	}

	public String toSting() {
		return "%15s"+name+"%20s"+description+"%03d"+hitPoints+"%02d"+damage;
	}

public void prnt(String x)throws FileNotFoundException, IOException{
	
		
		File OutF = new File("GameLog.txt");
		
		try {
			if(!OutF.exists()) {
				OutF.createNewFile();
			}
		
		
		FileWriter fw =new FileWriter(OutF,true);
		System.out.println(x);
		
		//fw.append(x+"\n");
		fw.close();
		}
		catch(IOException e) {
			System.out.println("could not log");
		}
	
	}
	

}
