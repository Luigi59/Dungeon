package dungeon;

import java.util.HashMap;
import java.util.Map;

import objects.Item;
import objects.Weapon;

/** A player in the game Dungeon */
public class Player extends Character {

	private Room currentRoom;
	private Map<String,Item> bag;
	
	/**
	 * 
	 * @param name the name of the player
	 * @param HP the number of health points of the player
	 */
	public Player(int health) {
		super(health, 1);
		this.currentRoom = null;
		this.bag = new HashMap<String,Item>();
	}
	
	/**
	 * Tells if the player is currently fighting or not.
	 * @return
	 */
	public boolean isInFight() {
		return this.getRoom().getMonster() != null && this.getHealth() > 0;
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
	
	public Map<String,Item> getBag() {
		return bag;
	}
	
	/**
	 * add a item into the bag
	 * @param item 
	 */
	public void addItem(Item item) {
		this.bag.put(item.getType(), item);
	}
	
	public int getAttack() {
		int res = super.getAttack();
		if(bag.containsKey("weapon") && !bag.get("weapon").equals(null)) {
			Weapon w = (Weapon) (bag.get("weapon"));
			res += w.getDamage();
		}
		return res;
	}
	
	public String toString() {
		return "You have " + health + "/" + maxHealth + " HP and " + attack + " ATK.";
	}
	
}
