package dungeon;

import java.io.File;
import java.util.Scanner;

public class Main {
	
	protected final static Scanner scanner = new Scanner(System.in);
	protected static Player p = new Player(10);
	protected static Dungeon d;
	protected static Game game;
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("\nWhich dungeon do you wanna play ? (enter the number of the dungeon)");
			System.out.print("> ");
			String line = scanner.nextLine();
			if(isInteger(line)) {
				File f = new File("dungeons/" + line + ".txt");
				if(f.exists() && !f.isDirectory()) {
					d = new Dungeon(Integer.parseInt(line));
					game = new Game(d, p);
					game.start();
				} else
					System.out.println("The dungeon number " + line + " does not exist");
			} else
				System.out.println(line + " is not a positive number.");
		}
		
		
		
	
		
	}
	
	public static boolean isInteger(String s) {
		if(s.length() < 1)
			return false;
		for(int i=0; i<s.length(); ++i) {
			if(!s.substring(i, i+1).matches("[0-9]"))
				return false;
		}
		return true;
	}
	
}