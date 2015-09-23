package dungeon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dungeon {

	
	protected final Scanner scanner = new Scanner(System.in);
	
	Map<Integer, Room> rooms;
	
	public Dungeon(int n) {
		rooms = new HashMap<Integer, Room>();
		initializeDungeon(n);
		System.out.println(rooms);
		System.out.println(rooms.get(1).getNeighbors());
		/**player = new Player("You", 10);
		player.setRoom(rooms.get(1));*/
	}
	
	public Room getRoomWithNumber(int number) {
		return this.rooms.get(number);
	}
	
	/**
	 * Reads the file given in parameter.<br>
	 * For each line, call the {@link Dungeon#readLine(String)} method.
	 * @param name
	 */
	public void readFile(String name) {
		try {
			InputStream is = new FileInputStream(name);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while((line = br.readLine()) != null) {
				readLine(line);
			}
			br.close();
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Reads the current line of file.<br>
	 * Adds Room(s) to the Map<Integer, Room> if it does not exists already.<br>
	 * Add the corresponding neighbor to the room given in the line informations.
	 * @param s - String
	 * @throws MapFileException
	 */
	public void readLine(String s) throws MapFileException {
		String[] tmp = s.split(" ");
		if(!rooms.containsKey(Integer.parseInt(tmp[0])))
			addRoomToMap(Integer.parseInt(tmp[0]), tmp[1]);
		
		if(!rooms.containsKey(Integer.parseInt(tmp[3])))
			addRoomToMap(Integer.parseInt(tmp[3]), tmp[4]);
	
		rooms.get(Integer.parseInt(tmp[0])).addNeighbor(tmp[2], rooms.get(Integer.parseInt(tmp[3])));		
	}
	
	/**
	 * Adds Room to the Map
	 * @param num
	 * @param type
	 * @throws MapFileException
	 */
	public void addRoomToMap(int num, String type) throws MapFileException {
		switch(type) {
		case "normal": rooms.put(num, new NormalRoom()); break;
		case "trap": rooms.put(num, new TrapRoom()); break;
		case "exit": rooms.put(num, new ExitRoom()); break;
		default: throw new MapFileException("Error into map's file.\n");
		}
	}
	
	public void initializeDungeon(int n) {
		String path = "dungeons/" + n + ".txt";
		readFile(path);
	}
	
	
}