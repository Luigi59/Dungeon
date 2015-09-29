package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import objects.Key;
import dungeon.NormalRoom;

public class KeyTest {

	private NormalRoom lockedRoom;
	private Key key;
	
	@Before
	public void createkey() {
		lockedRoom = new NormalRoom();
		 key = new Key("key1",lockedRoom);
	}
	
	@Test
	public void testGetName() {
		assertEquals("key1", key.getName());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("It's a key that opens a locked room", key.getDescription());
	}

	@Test
	public void testGetType() {
		assertEquals("key", key.getType());
	}
	
	@Test
	public void testGetRoom() {
		assertEquals(lockedRoom, key.getRoom());
	}

}
