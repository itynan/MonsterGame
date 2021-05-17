package gameinterfaces;
import java.io.*;
public class Player extends Creature implements iPlayer {

	int healAmount;
	
	//Creature c=new Creature() {};
	
	public Player(String name, String description, int hitPoints, int damage, int healAmount){
		
		super(name, description, hitPoints, damage);
		
		this.healAmount=healAmount;
	}
	
	
	
	public void heal() throws IOException,FileNotFoundException{
			
		int HP=getHitPoints();
		setHitPoints(HP+=healAmount);
			
	    super.prnt(super.getName()+" is healed by "+this.healAmount);
			
		
	}
	
}
