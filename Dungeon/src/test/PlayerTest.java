package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dungeon.NormalRoom;
import dungeon.Player;
import dungeon.Room;

public class PlayerTest {
	
	private Player p1;
	private Room normalRoom;
	
	@Before
	public void createPlayer() {
		p1 = new Player(10);
		normalRoom = new NormalRoom();
	}

	@Test
	public void testGetHealthPoints() {
		assertEquals(10,p1.getHealth());
	}

	@Test
	public void testSetHealthPoints() {
		p1.setHealth(20);
		assertEquals(20,p1.getHealth());
	}
	
	@Test
	public void testIdDead() {
		assertFalse(p1.isDead());
		p1.setHealth(0);
		assertTrue(p1.isDead());
	}

	@Test
	public void testGetRoom() {
		assertEquals(null,p1.getRoom());
	}

	@Test
	public void testSetRoom() {
		p1.setRoom(normalRoom);
		assertEquals(normalRoom,p1.getRoom());
	}

	@Test
	public void testToString() {
		assertEquals("Your name is : Estelle\nNumber of health points : 10",p1.toString());
	}

}
