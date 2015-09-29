package dungeon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entity.Button;
import entity.Chest;
import objects.Item;
import objects.Key;
import objects.Potion;
import objects.Weapon;

public class Dungeon {

	
	protected final Scanner scanner = new Scanner(System.in);
	
	protected Map<Integer, Room> rooms;
	
	/**
	 * a dungeon 
	 * @param n the number of the dungeon
	 */
	public Dungeon(int n) {
		rooms = new HashMap<Integer, Room>();
		initializeDungeon(n);
	}
	
	/**
	 * gives the Room with its number
	 * @param number the number of the room
	 * @return the room
	 */
	public Room getRoomWithNumber(int number) {
		return this.rooms.get(number);
	}
	
	/**
	 * Reads the file given in parameter.<br>
	 * For each line, call the {@link Dungeon#readLine(String)} method.
	 * @param name the name of the file
	 */
	public void readFile(String name) {
		try {
			InputStream is = new FileInputStream(name);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			if(name.startsWith("dungeons/")) {
				while((line = br.readLine()) != null)
					readDungeonLine(line);
			} else if(name.startsWith("monsters/")) {
				while((line = br.readLine()) != null)
					readMonsterLine(line);
			} else if(name.startsWith("chests/")) {
				while((line = br.readLine()) != null)
					readChestLine(line);
			} else if(name.startsWith("buttons/")) {
				while((line = br.readLine()) != null)
					readButtonLine(line);
			}
			br.close();
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Reads the current line of the file.<br>
	 * Adds Room(s) to the Map<Integer, Room> if it does not exists already.<br>
	 * Add the corresponding neighbor to the room given in the line informations.
	 * @param s - String
	 * @throws MapFileException
	 */
	public void readDungeonLine(String s) throws MapFileException {
		String[] tmp = s.split(" ");
		if(!rooms.containsKey(Integer.parseInt(tmp[0])))
			addRoomToMap(Integer.parseInt(tmp[0]), tmp[1], Boolean.parseBoolean(tmp[2]));
		
		if(!rooms.containsKey(Integer.parseInt(tmp[4])))
			addRoomToMap(Integer.parseInt(tmp[4]), tmp[5], Boolean.parseBoolean(tmp[6]));
	
		rooms.get(Integer.parseInt(tmp[0])).addNeighbor(tmp[3], rooms.get(Integer.parseInt(tmp[4])));		
	}
	
	/**
	 * Reads the current line of the file.<br>
	 * Add Monster to a room
	 * @param s
	 * @throws MonsterFileException
	 */
	public void readMonsterLine(String s) throws MonsterFileException {
		String[] tmp = s.split(":");
		rooms.get(Integer.parseInt(tmp[0])).setMonster(new Monster(tmp[1], Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3])));
	}
	
	/**
	 * Read the current line of the file.<br>
	 * Add Chest to a room
	 * @param s
	 * @throws ChestFileException
	 */
	public void readChestLine(String s) throws ChestFileException {
		String[] tmp = s.split(":");
		Room room = rooms.get(Integer.parseInt(tmp[0]));
		Item item;
		switch(tmp[1]) {
		case "weapon": item = new Weapon(tmp[2], Integer.parseInt(tmp[3])); break;
		case "potion": item = new Potion(tmp[2], Integer.parseInt(tmp[3])); break;
		case "key": item = new Key(tmp[2], rooms.get(Integer.parseInt(tmp[3]))); break;
		default: throw new ChestFileException("Item of type " + tmp[1] + " doesn't exists.");
		}
		room.setChest(new Chest(item));
	}
	
	public void readButtonLine(String s) throws ButtonFileException {
		String[] tmp = s.split(":");
		Room room = rooms.get(Integer.parseInt(tmp[0]));
		Room unlock = rooms.get(Integer.parseInt(tmp[1]));
		room.setButton(new Button(unlock));
	}
	
	/**
	 * Adds Room to the Map
	 * @param num the number of the room
	 * @param type the type of the room
	 * @throws MapFileException
	 */
	public void addRoomToMap(int num, String type, boolean locked) throws MapFileException {
		switch(type) {
		case "normal": rooms.put(num, new NormalRoom(locked)); break;
		case "trap": rooms.put(num, new TrapRoom(locked)); break;
		case "exit": rooms.put(num, new ExitRoom(locked)); break;
		default: throw new MapFileException("Error into map's file.\n");
		}
	}
	
	/**
	 * initialize the dungeon
	 * @param n the number of the dungeon
	 */
	public void initializeDungeon(int n) {
		String path = "dungeons/" + n + ".txt";
		readFile(path);
		path = "monsters/" + n + ".txt";
		readFile(path);
		path = "chests/" + n + ".txt";
		readFile(path);
		path = "buttons/" + n + ".txt";
		readFile(path);
	}
	
	
}