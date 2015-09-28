package dungeon;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Room {

	protected Map<String,Room> neighbors;
	protected boolean locked;
	protected Monster monster;
	
	/**
	 * If no parameter, by default a room is not locked and has no monster.
	 */
	public Room() {
		this(false, null);
	}
	
	/**
	 * Room locked or not, with no monster
	 * @param locked
	 */
	public Room(boolean locked) {
		this(locked, null);
	}
	
	/**
	 * Room with a monster
	 * @param monster
	 */
	public Room(Monster monster) {
		this(false, monster);
	}
	
	/**
	 * Room locked or not, with a monster
	 * @param locked
	 * @param monster
	 */
	public Room(boolean locked, Monster monster) {
		this.neighbors = new HashMap<String,Room>();
		this.locked = locked;
		this.monster = monster;
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
		res += "You can go ";
		if(getNeighbors().size() < 1)
			res += "nowhere !";
		else
			for(Entry<String, Room> entry : neighbors.entrySet())
				res += entry.getKey() +", ";
		res = res.substring(0, res.length()-2) + ".";
		//res += "(infos supplémentaires : directions possibles, boutons, monstres, coffres, peintures, tapis, etc...)";
		return res;
	}
	
	/**
	 * Tells if the room is locked or not.
	 * @return
	 */
	public boolean isLocked() {
		return locked;
	}
	
	/**
	 * Locks the room.
	 */
	public void lock() {
		locked = true;
	}
	
	/**
	 * Unlocks the room.
	 */
	public void unlock() {
		locked = false;
	}
	
	/**
	 * Get the monster of the room, or null if there is none.
	 * @return Monster
	 */
	public Monster getMonster() {
		return monster;
	}
	
	/**
	 * Set the monster of the room.
	 * @param monster
	 */
	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	
}
