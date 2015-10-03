package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dungeon.NormalRoom;
import entity.Chest;
import objects.Item;
import objects.Key;
import objects.Potion;
import objects.Weapon;

public class ChestTest {
	
	Chest c1, c2, c3, c4;
	Item weapon, key, potion;
	
	@Before
	public void createChest() {
		weapon = new Weapon("Wooden sword", 1);
		key = new Key("Small key", new NormalRoom());
		potion = new Potion("Healing potion", 1);
		c1 = new Chest(weapon);
		c2 = new Chest(key);
		c3 = new Chest(potion);
		c4 = new Chest(null);
	}
	
	@Test
	public void testOpen() {
		assertEquals(weapon, c1.open());
		assertEquals(key, c2.open());
		assertEquals(potion, c3.open());
		assertEquals(null, c4.open());
	}

}
