package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import dungeon.ItemDoesNotExist;
import dungeon.Monster;
import dungeon.NormalRoom;
import dungeon.Player;
import dungeon.Room;
import objects.Item;
import objects.Key;
import objects.Potion;
import objects.Weapon;

public class CharacterTest {
	
	private Player p1;
	private Room normalRoom;
	private Monster m1;
	private Potion potion;
	
	@Before
	public void createCharacters() throws ItemDoesNotExist {
		p1 = new Player(10);
		normalRoom = new NormalRoom();
		m1 = new Monster("Slime", 5, 1);
		potion = new Potion("Healing potion", 10);
		p1.addItem(potion);
	}

	@Test
	public void testGetHealth() {
		assertEquals(10,p1.getHealth());
		assertEquals(5, m1.getHealth());
	}

	@Test
	public void testSetHealthPoints() {
		p1.setHealth(20);
		assertEquals(20,p1.getHealth());
		m1.setHealth(3);
		assertEquals(3, m1.getHealth());
	}
	
	@Test
	public void testGetMaxHealth() {
		assertEquals(10, p1.getMaxHealth());
		p1.setHealth(1);
		assertEquals(10, p1.getMaxHealth());
		assertEquals(5, m1.getMaxHealth());
		m1.setHealth(1);
		assertEquals(5, m1.getMaxHealth());
	}
	
	@Test
	public void testIsDead() {
		assertFalse(p1.isDead());
		p1.setHealth(0);
		assertTrue(p1.isDead());
		assertFalse(m1.isDead());
		m1.setHealth(-1);
		assertTrue(m1.isDead());
	}
	
	@Test
	public void testGetAttack() throws ItemDoesNotExist {
		assertEquals(1, m1.getAttack());
		assertEquals(1, p1.getAttack());
		p1.addItem(new Weapon("Excalibur", 50));
		assertEquals(51, p1.getAttack());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Slime", m1.getName());
	}

	@Test
	public void testGetRoom() {
		assertEquals(null,p1.getRoom());
		p1.setRoom(normalRoom);
		assertEquals(normalRoom,p1.getRoom());
	}

	@Test
	public void testSetRoom() {
		p1.setRoom(normalRoom);
		assertEquals(normalRoom,p1.getRoom());
	}
	
	@Test
	public void testIsInFight() {
		p1.setRoom(normalRoom);
		assertFalse(p1.isInFight());
		normalRoom.setMonster(m1);
		assertTrue(p1.isInFight());
		p1.setHealth(0);
		assertFalse(p1.isInFight());
	}
	
	@Test
	public void testGetBag() {
		Map<String, Item> map = new HashMap<String, Item>();
		map.put("potion", potion);
		assertEquals(map, p1.getBag());
	}
	
	@Test
	public void testAddItem() throws ItemDoesNotExist {
		Item weapon = new Weapon("Excalibur", 50);
		Map<String, Item> map = new HashMap<String, Item>();
		map.put("potion", potion);
		map.put("weapon", weapon);
		p1.addItem(weapon);
		assertEquals(map, p1.getBag());
		assertEquals(0, p1.getKeys().size());
		p1.addItem(new Key("Small key", new NormalRoom()));
		assertEquals(1, p1.getKeys().size());
		
		// Test if the old weapon / potion stay when we add a worse weapon / potion
		p1.addItem(new Weapon("Wooden sword", 1));
		assertEquals(weapon, p1.getBag().get("weapon"));
		p1.addItem(new Potion("potion", 1));
		assertEquals(potion, p1.getBag().get("potion"));
		
		// Test is the old weapon / potion is replaced by a better weapon / potion
		Item weapon2 = new Weapon("Excalibur 2.0", 100);
		p1.addItem(weapon2);
		assertEquals(weapon2, p1.getBag().get("weapon"));
		Item potion2 = new Potion("potion", 20);
		p1.addItem(potion2);
		assertEquals(potion2, p1.getBag().get("potion"));
	}
	
	/*@Test(expected=ItemDoesNotExist.class)
	public void testAddNonExistingItem() throws ItemDoesNotExist {
		
	}*/

	@Test
	public void testDrinkPotion() {
		Map<String, Item> bag = new HashMap<String, Item>();
		p1.setHealth(5);
		p1.drinkPotion(potion);
		assertEquals(10, p1.getHealth());
		assertEquals(bag, p1.getBag());
	}
	
	@Test
	public void testGetInventory() {
		assertEquals("Items : Healing potion\nKeys : 0", p1.getInventory());
		Player p2 = new Player(10);
		assertEquals("Items : none\nKeys : 0", p2.getInventory());
	}
	
	@Test
	public void testToString() {
		assertEquals("You have " + p1.getHealth() + "/" + p1.getMaxHealth() + " HP and " + p1.getAttack() + " ATK.", p1.toString());
		assertEquals(m1.getName() + " (HP : " + m1.getHealth() + "/" + m1.getMaxHealth() + " ; ATK : " + m1.getAttack() + ")", m1.toString());
	}

}
