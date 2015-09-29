package dungeon;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import entity.Button;
import entity.Chest;

public abstract class Room {

	protected Map<String,Room> neighbors;
	protected boolean locked;
	protected Monster monster;
	protected Chest chest;
	protected Button button;
	
	/**
	 * If no parameter, by default a room is not locked and has no monster.
	 */
	public Room() {
		this.neighbors = new HashMap<String,Room>();
		this.locked = false;
		this.monster = null;
		this.chest = null;
		this.button = null;
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
		res = res.substring(0, res.length()-2) + ".\n";
		if(chest != null && button != null)
			res += "There is a chest and a button.";
		else if(chest != null && button == null)
			res += "There is a chest.";
		else if(chest == null && button != null)
			res += "Theres is a button.";
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
	
	/**
	 * Get the chest of the room, or null if there is none.
	 * @return
	 */
	public Chest getChest() {
		return chest;
	}
	
	/**
	 * Set the chest of the room.
	 * @param chest
	 */
	public void setChest(Chest chest) {
		this.chest = chest;
	}
	
	/**
	 * Get the button of the room, or null if there is none.
	 * @return
	 */
	public Button getButton() {
		return button;
	}
	
	/**
	 * Set the button of the room.
	 * @param button
	 */
	public void setButton(Button button) {
		this.button = button;
	}
	
}
