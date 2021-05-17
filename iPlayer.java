package gameinterfaces;
import java.io.*;
import java.lang.*;
import java.util.*;

public interface iPlayer extends iCreature {
	
	/*String name=""; 
	String description="";
	int hitPoints=0; int damage=0; int healAmount=0;
	
	*/
	
	void heal() throws IOException, FileNotFoundException;
	
	
}

