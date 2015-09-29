package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import dungeon.ButtonFileException;
import dungeon.ChestFileException;
import dungeon.Dungeon;
import dungeon.MapFileException;
import dungeon.Monster;
import dungeon.MonsterFileException;
import dungeon.NormalRoom;
import dungeon.Room;
import entity.Button;
import entity.Chest;
import objects.Key;
import objects.Potion;
import objects.Weapon;

public class DungeonTest {
	
	private Dungeon dungeon;
	Map<Integer, Room> rooms;
	
	@Before
	public void createDungeon() throws MapFileException {
		dungeon = new Dungeon();
		dungeon.addRoomToMap(1, "normal", false);
		dungeon.addRoomToMap(2, "trap", false);
		dungeon.addRoomToMap(3, "exit", false);
		dungeon.getRoomWithNumber(1).getNeighbors().put("west", dungeon.getRoomWithNumber(2));
		dungeon.getRoomWithNumber(1).getNeighbors().put("north", dungeon.getRoomWithNumber(3));
		dungeon.getRoomWithNumber(2).getNeighbors().put("east", dungeon.getRoomWithNumber(1));
		dungeon.getRoomWithNumber(3).getNeighbors().put("south", dungeon.getRoomWithNumber(1));
		rooms = new HashMap<Integer, Room>();
		rooms.put(1, dungeon.getRoomWithNumber(1));
		rooms.put(2, dungeon.getRoomWithNumber(2));
		rooms.put(3, dungeon.getRoomWithNumber(3));
	}
	
	@Test
	public void testGetMap() {
		assertEquals(rooms, dungeon.getMap());
	}
	
	@Test
	public void testReadDungeonLine() throws MapFileException {
		String line = "4 normal false north 5 normal false";
		String[] tmp = line.split(" ");
		assertFalse(dungeon.getMap().containsKey(Integer.parseInt(tmp[0])));
		assertFalse(dungeon.getMap().containsKey(Integer.parseInt(tmp[4])));
		dungeon.readDungeonLine(line);
		assertTrue(dungeon.getMap().containsKey(Integer.parseInt(tmp[0])));
		assertTrue(dungeon.getMap().containsKey(Integer.parseInt(tmp[4])));
	}
	
	@Test
	public void testReadMonsterLine() throws MonsterFileException {
		String line = "2:Slime:5:1";
		String[] tmp = line.split(":");
		Monster munch = new Monster(tmp[1], Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
		assertEquals(null, dungeon.getMap().get(Integer.parseInt(tmp[0])).getMonster());
		dungeon.readMonsterLine(line);
		assertEquals(munch, dungeon.getMap().get(Integer.parseInt(tmp[0])).getMonster());
	}
	
	@Test
	public void testReadChestLine() throws ChestFileException {
		String line1 = "1:weapon:Wooden sword:1";
		Chest c1 = new Chest(new Weapon("Wooden sword", 1));
		assertEquals(null, dungeon.getMap().get(1).getChest());
		dungeon.readChestLine(line1);
		assertEquals(c1, dungeon.getMap().get(1).getChest());
		
		String line2 = "2:key:Small key:3";
		Chest c2 = new Chest(new Key("Small key", dungeon.getMap().get(3)));
		assertEquals(null, dungeon.getMap().get(2).getChest());
		dungeon.readChestLine(line2);
		assertEquals(c2, dungeon.getMap().get(2).getChest());
		
		String line3 = "3:potion:Healing potion:3";
		Chest c3 = new Chest(new Potion("Healing potion", 3));
		assertEquals(null, dungeon.getMap().get(3).getChest());
		dungeon.readChestLine(line3);
		assertEquals(c3, dungeon.getMap().get(3).getChest());
	}
	
	@Test
	public void testReadButtonLine() throws ButtonFileException {
		String line = "1:2";
		String[] tmp = line.split(":");
		Button b = new Button(dungeon.getMap().get(2));
		assertEquals(null, dungeon.getMap().get(1).getButton());
		dungeon.readButtonLine(line);
		assertEquals(b, dungeon.getMap().get(1).getButton());
	}
	
}
