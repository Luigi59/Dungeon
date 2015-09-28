package dungeon;

import java.util.HashMap;
import java.util.Map;

import dungeon.objects.Item;

/** A player in the game Dungeon */
public class Player {

	private String name;
	private int healthPoints;
	private Room currentRoom;
	private Map<String,Item> bag;
	
	/**
	 * 
	 * @param name the name of the player
	 * @param HP the number of health points of the player
	 */
	public Player(String name,int HP) {
		this.name = name;
		this.healthPoints = HP;
		this.currentRoom = null;
		this.bag = new HashMap<String,Item>();
	}
	
	/**
	 * gives the number of health points
	 * @return the number of health points
	 */
	public int getHealthPoints() {
		return this.healthPoints;
	}
	
	/**
	 * changes the health points of the player
	 * @param HP the new number of health points
	 */
	public void setHealthPoints(int HP) {
		if (isDead())
			System.out.println("You are dead!");
		else
		this.healthPoints = HP;
	}
	
	/**
	 * Tells if the player is dead or not.
	 * @return boolean
	 */
	public boolean isDead() {
		return this.healthPoints <= 0;
	}
	
	/**
	 * Tells if the player is currently fighting or not.
	 * @return
	 */
	public boolean isInFight() {
		return this.getRoom().getMonster() != null && this.getHealthPoints() > 0;
	}
	
	/**
	 * gives the current Room of the player
	 * @return the current Room of the player
	 */
	public Room getRoom() {
		return this.currentRoom;
	}
	
	/**
	 * changes the Room of the player
	 * @param newRoom the new Room
	 */
	public void setRoom(Room newRoom) {
		this.currentRoom = newRoom;
	}
	
	/**
	 * add a item into the bag
	 * @param item 
	 */
	public void addItem(Item item) {
		this.bag.put(item.getName(),item);
	}
	
	/**
	 * gives a description of the player
	 * @return the description of the player
	 */
	public String toString() {
		String s = "Your name is : "+this.name+"\nNumber of health points : "+this.healthPoints;
		return s;
	}
}
