package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import dungeon.ExitRoom;
import dungeon.Monster;
import dungeon.NormalRoom;
import dungeon.Room;
import dungeon.TrapRoom;
import entity.Button;
import entity.Chest;
import objects.Weapon;

public class RoomTest {
	
	Room normalRoom;
	Room trapRoom;
	Room exitRoom;
	
	@Before
	public void createRooms() {
		normalRoom = new NormalRoom();
		trapRoom = new TrapRoom();
		exitRoom = new ExitRoom();
		normalRoom = new NormalRoom(false);
		trapRoom = new TrapRoom(false);
		exitRoom = new ExitRoom(false);
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
	
	@Test(expected=NullPointerException.class)
	public void testNeighborDoesNotExist() {
		normalRoom.getNeighbor("south");
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
		assertEquals("an intersection.", normalRoom.getDescription());
		assertEquals("the exit!", exitRoom.getDescription());
		assertEquals("a trap!", trapRoom.getDescription());
	}
	
	@Test
	public void testGetFullDescription() {
		normalRoom.setButton(new Button(exitRoom));
		normalRoom.setChest(new Chest(new Weapon("Wooden sword", 1)));
		trapRoom.setButton(new Button(exitRoom));
		exitRoom.setChest(new Chest(new Weapon("Excalibur", 50)));
		assertEquals("an intersection.\nYou can go north, west.\nThere is a chest and a button.", normalRoom.getFullDescription());
		assertEquals("a trap!\nYou can go east.\nThere is a button.", trapRoom.getFullDescription());
		assertEquals("the exit!\nYou can go south.\nThere is a chest.", exitRoom.getFullDescription());
		assertEquals("an intersection.\nYou can go nowhere.\n", new NormalRoom().getFullDescription());
	}
	
	@Test
	public void testCanBeLeft() {
		assertEquals(true, normalRoom.canBeLeft());
		assertEquals(true, exitRoom.canBeLeft());
		assertEquals(false, trapRoom.canBeLeft());
	}
	
	@Test
	public void testIsLocked() {
		assertFalse(normalRoom.isLocked());
		normalRoom.lock();
		assertTrue(normalRoom.isLocked());
		normalRoom.unlock();
		assertFalse(normalRoom.isLocked());
	}
	
	@Test
	public void testGetMonster() {
		assertEquals(null, normalRoom.getMonster());
		Monster munch = new Monster("munch", 1, 1);
		normalRoom.setMonster(munch);
		assertEquals(munch, normalRoom.getMonster());
	}
	
	@Test
	public void testGetChest() {
		assertEquals(null, normalRoom.getChest());
		Chest c = new Chest(new Weapon("test", 1));
		normalRoom.setChest(c);
		assertEquals(c, normalRoom.getChest());
	}
	
	@Test
	public void testGetButton() {
		assertEquals(null, normalRoom.getButton());
		Button b = new Button(exitRoom);
		normalRoom.setButton(b);
		assertEquals(b, normalRoom.getButton());
	}

}
