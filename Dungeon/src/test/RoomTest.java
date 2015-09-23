package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
	
	@Test
	public void testGetNeighbors() {
		Map<String, Room> normalRoomNeighbors = new HashMap<String, Room>();
		normalRoomNeighbors.put("west", trapRoom);
		normalRoomNeighbors.put("north", exitRoom);
		assertEquals(normalRoomNeighbors, normalRoom.getNeighbors());
		
		Map<String, Room> trapRoomNeighbors = new HashMap<String, Room>();
		trapRoomNeighbors.put("east", normalRoom);
		assertEquals(trapRoomNeighbors, trapRoom.getNeighbors());
		
		Map<String, Room> exitRoomNeighbors = new HashMap<String, Room>();
		exitRoomNeighbors.put("south", normalRoom);
		assertEquals(exitRoomNeighbors, exitRoom.getNeighbors());
	}
	
	@Test
	public void testAddNeighbor() {
		Room entrance = new NormalRoom();
		Room trap = new TrapRoom();
		
		entrance.addNeighbor("north", trap);
		trap.addNeighbor("south", entrance);
		
		assertEquals(trap, entrance.getNeighbor("north"));
		assertEquals(entrance, trap.getNeighbor("south"));
		
		Map<String, Room> entranceNeighbors = new HashMap<String, Room>();
		Map<String, Room> trapNeighbors = new HashMap<String, Room>();
		entranceNeighbors.put("north", trap);
		trapNeighbors.put("south", entrance);
		
		assertEquals(entranceNeighbors, entrance.getNeighbors());
		assertEquals(trapNeighbors, trap.getNeighbors());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("It's an intersection.", normalRoom.getDescription());
		assertEquals("This is the exit!", exitRoom.getDescription());
		assertEquals("It's a trap!", trapRoom.getDescription());
	}
	
	// test

}
