package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import objects.Potion;

public class PotionTest {

	private Potion potion;
	
	@Before
	public void createPotion() {
		potion = new Potion("potion1", 5);
	}
	
	@Test
	public void testGetName() {
		assertEquals("potion1", potion.getName());
	}
	@Test
	public void testGetHpWin() {
		assertEquals(5, potion.getHpWin());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("It's a potion that restores 5 health point(s)", potion.getDescription());
	}

	@Test
	public void testGetType() {
		assertEquals("potion", potion.getType());
	}
}
