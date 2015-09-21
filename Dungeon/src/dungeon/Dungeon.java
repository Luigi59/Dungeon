package dungeon;

import java.util.Scanner;

public class Dungeon {

	private Player player;
	
	protected final Scanner scanner = new Scanner(System.in);
	
	public Dungeon(int n) {
		
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