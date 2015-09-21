package dungeon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dungeon {

	private Player player;
	
	protected final Scanner scanner = new Scanner(System.in);
	
	Map<Integer, Room> rooms;
	
	public Dungeon(int n) {
		rooms = new HashMap<Integer, Room>();
		String path = "../../dungeons/" + n + ".txt";
		readFile(path);
	}
	
	/**
	 * Reads the file given in paramater.<br>
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
		if(!rooms.containsKey(Integer.parseInt(tmp[0]))) {
			switch(tmp[1]) {
			case "normal": rooms.put(Integer.parseInt(tmp[0]), new NormalRoom()); break;
			case "trap": rooms.put(Integer.parseInt(tmp[0]), new TrapRoom()); break;
			case "exit": rooms.put(Integer.parseInt(tmp[0]), new ExitRoom()); break;
			default: throw new MapFileException("Error into map's file.\n");
			}	
		} else if(!rooms.containsKey(Integer.parseInt(tmp[3]))) {
			switch(tmp[4]) {
			case "normal": rooms.put(Integer.parseInt(tmp[3]), new NormalRoom()); break;
			case "trap": rooms.put(Integer.parseInt(tmp[3]), new TrapRoom()); break;
			case "exit": rooms.put(Integer.parseInt(tmp[3]), new ExitRoom()); break;
			default: throw new MapFileException("Error into map's file.\n");
			}
		}
		rooms.get(tmp[0]).addNeighbor(tmp[2], rooms.get(tmp[3]));
	}
	
	public void initializeDungeon() {
		
	}
	
	public void interpretCommand(String command) {
		Room currentRoom = this.player.getRoom();
		Room newRoom = currentRoom.getNeighbor(command);
		switch(command) {
		case "go north" :
			this.player.setRoom(newRoom);
			break;
		case "go south" :
			this.player.setRoom(newRoom);
			break;
		case "go west" :
			this.player.setRoom(newRoom);
			break;
		case "go east" :
			this.player.setRoom(newRoom);
			break;
		}
	}
	
}