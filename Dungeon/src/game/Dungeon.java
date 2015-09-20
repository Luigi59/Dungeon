package game;

import java.util.Scanner;

public class Dungeon {
	
	protected String currentRoom = "entrance";
	protected boolean gameIsFinished = false;
	protected final Scanner scanner = new Scanner(System.in);
	
	public String getCurrentRoom() {
		return currentRoom;
	}
	
	public void interpretCommand() {
		
		// Read a command from the user (stdin)
		String command = scanner.nextLine();
		switch(command) {
		case "go north":
			goNorth();
			break;
		case "go west":
			goWest();
			break;
		default:
			System.out.println("I don't know what you mean");
		}
		
	}
	
	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon();
		dungeon.start();
	}
	
	public void start() {
		do {
			System.out.println("You are in " + getCurrentRoom());
			System.out.println("What do you want to do?");
			System.out.print("> ");
			
			interpretCommand();
		} while (!gameIsFinished());
		
		System.out.println("You are in " + getCurrentRoom());
		if (gameIsWon()) {
			System.out.println("You win!");
		} else {
			System.out.println("You loose!");
		}
	}
	
	public boolean gameIsFinished() {
		return gameIsLost() || gameIsWon();
	}
	
	public boolean gameIsLost() {
		return currentRoom.equals("trap");
	}
	
	public boolean gameIsWon() {
		return currentRoom.equals("exit");
	}
	
	public void goNorth() {
		switch(currentRoom) {
		case "entrance":
			currentRoom = "intersection";
			break;
		case "intersection":
			currentRoom = "exit";
			break;
		}
	}
	
	public void goWest() {
		switch(currentRoom) {
		case "intersection":
			currentRoom = "trap";
			break;
		case "entrance":
			System.out.println("Can't go west!");
			break;
		}
	}

}
