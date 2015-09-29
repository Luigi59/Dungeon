package test;

import static org.junit.Assert.*;
import objects.Weapon;

import org.junit.Before;
import org.junit.Test;

public class WeaponTest {

	private Weapon weapon;
	
	@Before
	public void createWeapon() {
		weapon = new Weapon("Wooden sword",1);
	}

	@Test
	public void testGetName() {
		assertEquals("Wooden sword", weapon.getName());
	}
	@Test
	public void testGetDamage() {
		assertEquals(1, weapon.getDamage());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("It's a weapon with 1 damage(s)", weapon.getDescription());
	}

	@Test
	public void testGetType() {
		assertEquals("weapon", weapon.getType());
	}
}
