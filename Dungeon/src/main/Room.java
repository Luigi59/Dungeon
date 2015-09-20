package main;

import java.util.HashMap;
import java.util.Map;


public abstract class Room {

	private Map<String,Room> neighbors;
	
	private Stair stair;
	
	public abstract boolean canBeLeft();
	
	public abstract String getDescription();
	
	public Room(Stair stair) {
		this.stair = stair;
		generateNeighbors();
	}
	
	public Map<String,Room> generateNeighbors() {
		neighbors = new HashMap<String,Room>();
		neighbors.put("north",randomRoom());
		neighbors.put("south",randomRoom());
		neighbors.put("east",randomRoom());
		neighbors.put("west",randomRoom());
		return neighbors;
	}
	
	public Room randomRoom() {
		
		double r = Math.random()*10;
		if (r<1)
			return new ExitRoom();
		else if (r<2) 
			return new TrapRoom();
		else if (r<4)
			return null;
		else
			return new NormalRoom();	
	}
}
