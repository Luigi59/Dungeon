package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dungeon.NormalRoom;
import dungeon.Player;
import dungeon.PlayerDeadException;
import dungeon.Room;

public class PlayerTest {
	
	private Player p1;
	private Room normalRoom;
	
	@Before
	public void createPlayer() {
		p1 = new Player("Estelle",10);
		normalRoom = new NormalRoom();
	}

	@Test
	public void testGetHealthPoints() {
		assertEquals(10,p1.getHealthPoints());
	}

	@Test
	public void testSetHealthPoints() throws PlayerDeadException  {
	try {
		p1.setHealthPoints(0);
	} catch (PlayerDeadException e) {
		e.getMessage();
	}
	p1.setHealthPoints(20);
	assertEquals(20,p1.getHealthPoints());
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

	//test
	
}
