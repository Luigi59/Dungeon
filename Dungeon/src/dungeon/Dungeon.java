package dungeon;

import java.util.Scanner;

public abstract class Dungeon {

	private Player player;
	
	protected final Scanner scanner = new Scanner(System.in);
	
	public Dungeon() {
		
	}
	
	public abstract void initializeDungeon();
	
	public void interpretCommand(String command) {
		Room currentRoom = this.player.getRoom();
		Room newRoom = currentRoom.getNeigbor(command);
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