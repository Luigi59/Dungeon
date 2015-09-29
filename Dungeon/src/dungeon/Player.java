package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import objects.Item;
import objects.Key;
import objects.Potion;
import objects.Weapon;

/** A player in the game Dungeon */
public class Player extends Character {

	protected Room currentRoom;
	protected Map<String,Item> bag;
	protected List<Key> keys;
	
	/**
	 * 
	 * @param name the name of the player
	 * @param HP the number of health points of the player
	 */
	public Player(int health) {
		super(health, 1);
		this.currentRoom = null;
		this.bag = new HashMap<String,Item>();
		keys = new ArrayList<Key>();
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
		switch(item.getType()) {
		// weapon
		case "weapon":
			if(bag.containsKey("weapon")) {
				Weapon oldWeapon = (Weapon) bag.get("weapon");
				Weapon newWeapon = (Weapon) item;
				if(newWeapon.getDamage() > oldWeapon.getDamage())
					this.bag.put(item.getType(), item);
				else {
					System.out.println("You have already a similar or better weapon.");
					System.out.println("You drop the weapon.");
				}
			}
			break;
		//potion
		case "potion":
			if(bag.containsKey("potion")) {
				Potion oldPotion = (Potion) bag.get("potion");
				Potion newPotion = (Potion) item;
				if(newPotion.getHpWin() > oldPotion.getHpWin())
					this.bag.put(item.getType(), item);
				else {
					System.out.println("You have already a similar or better potion.");
					System.out.println("You drop the potion.");
				}
			}
			break;
		}
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
	
	public List<Key> getKeys() {
		return keys;
	}
	
	public void drinkPotion(Potion potion) {
		int tmp = health;
		health += potion.getHpWin();
		if(health > maxHealth)
			health = maxHealth;
		tmp = health - tmp;
		System.out.println("You drink " + potion.getName() + " and restore " + tmp + "health points.");
		getBag().remove("potion");
	}
	
	public String getInventory() {
		String res = "";
		res += "Items : ";
		if(bag.size() < 1)
			res += "none\n";
		else {
			for(Entry<String, Item> entry : bag.entrySet())
				res += entry.getValue().getName() + ", ";
			res = res.substring(0, res.length()-2) + "\n";
		}
		res += "Keys : " + keys.size();
		return res;
	}
	
	public String toString() {
		return "You have " + health + "/" + maxHealth + " HP and " + attack + " ATK.";
	}
	
}
