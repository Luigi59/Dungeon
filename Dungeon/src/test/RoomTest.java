package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import dungeon.ExitRoom;
import dungeon.NormalRoom;
import dungeon.Room;
import dungeon.TrapRoom;

public class RoomTest {
	
	Room normalRoom;
	Room trapRoom;
	Room exitRoom;
	
	@Before
	public void createRooms() {
		normalRoom = new NormalRoom();
		trapRoom = new TrapRoom();
		exitRoom = new ExitRoom();
		normalRoom.getNeighbors().put("west", trapRoom);
		trapRoom.getNeighbors().put("east", normalRoom);
		normalRoom.getNeighbors().put("north", exitRoom);
		exitRoom.getNeighbors().put("south", normalRoom);
	}
	
	@Test
	public void testGetNeighbor() {
		assertEquals(trapRoom, normalRoom.getNeighbor("west"));
		assertEquals(normalRoom, trapRoom.getNeighbor("east"));
		assertEquals(exitRoom, normalRoom.getNeighbor("north"));
		assertEquals(normalRoom, exitRoom.getNeighbor("south"));
	}

}
