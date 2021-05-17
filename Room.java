package gameinterfaces;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Room extends Creature implements iRoom {
	int roomIndex;
	String description;
	Monster monster;

	public Room(int roomIndex, String description, Monster monster) {
		this.roomIndex = roomIndex;
		this.description = description;
		this.monster = monster;
	}

	@Override
	public boolean isComplete() {
		if (monster.isAlive()) {
			return false;
		}
		return true;
	}

	@Override
	public void enter(Player player) throws FileNotFoundException,IOException{
		prnt(player.getName());
		prnt("This Room is " + description + " and has " + monster.getName());
		new Battle(player, monster).run();
	}

	public String toString() {
		return "Room index %2d" + roomIndex + " description %20s" + description + "monster name %20s"
				+ monster.getName();
	}

}
