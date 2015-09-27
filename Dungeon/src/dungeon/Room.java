package dungeon;

import java.util.HashMap;
import java.util.Map;

public abstract class Room {

	protected Map<String,Room> neighbors;	
	
	public Room() {
		this.neighbors = new HashMap<String,Room>();
	}
	
	/**
	 * add a adjacent room to the room depending of the desired direction
	 * @param direction the desired direction
	 * @param name the name of the room added
	 */
	public void addNeighbor(String direction,Room name) {
		this.neighbors.put(direction, name);
	}
	
	/**
	 * gives the room with its associated direction
	 * @param direction 
	 * @return the room with its direction
	 * @exception 
	 */
	public Room getNeighbor(String direction) throws NullPointerException {
		if (this.neighbors.containsKey(direction)) {
			return this.neighbors.get(direction);
		}
		else {
			throw new NullPointerException();
		}
	}
	
	/**
	 * give all neighbors associated to this room
	 * @return room's neighbors
	 */
	public Map<String,Room> getNeighbors() {
		return this.neighbors;
	}
	
	/**
	 * tells if a player can leaves the room
	 * @return <tt>true</tt> if and only if the player in this room can freely
	 *  leaves the room
	 */
	public abstract boolean canBeLeft();
	
	/**
	 * gives the type of the room
	 * @return the description of the room
	 */
	public abstract String getDescription();
	
	public String getFullDescription() {
		String res = getDescription() + "\n";
		res += "(infos supplémentaires : directions possibles, boutons, monstres, coffres, peintures, tapis, etc...)";
		return res;
	}
	
}
