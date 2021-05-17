package gameinterfaces;
import java.io.*;

public class Monster extends Creature implements iMonster {
	boolean isEnraged; // prevents monster from enraging twice
	int enragedThreshold;
	
	Creature c = new Creature() {};
	
	
	public Monster(String name, String description, int hitPoints, int damage,int enragedThreshold) {
		super(name, description, hitPoints, damage);
		this.enragedThreshold=enragedThreshold;
		this.isEnraged = false;
	}
	
	
	
	public boolean canEnrage() {
		
		if(super.getHitPoints()<enragedThreshold) {
			return true;
		}
		
		return false;
	}
	
	
	public void enrage() throws FileNotFoundException,IOException  {
		
		if(canEnrage()&&!isEnraged) {
			super.setDamage(super.getDamage()*2);
			
			isEnraged= true;
		super.prnt(super.getName()+" has been enraged");
		}

	}

	
	

}
