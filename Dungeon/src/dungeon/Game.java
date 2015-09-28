package dungeon;

public class Game {

	private Player player;
	
	private Dungeon dungeon;
	
	public Game(Dungeon dungeon, Player player) {
		this.dungeon = dungeon;
		this.player = player;
		Room entrance = this.dungeon.getRoomWithNumber(1);
		this.player.setRoom(entrance);
	}
	
	/**
	 * start the game
	 */
	public void start() {
		System.out.println(getGameDescription());
		do {
			System.out.println("You are in "+ this.player.getRoom().getFullDescription());
			System.out.println("What do you want to do?");
			System.out.print("> ");
			
			String line = dungeon.scanner.nextLine();
			interpretCommand(line);
		} while (!gameIsFinished());
		if (gameIsWon()) {
			System.out.println("You win!");
		} else {
			System.out.println("You loose!");
		}
	}
	
	/**
	 * tells if the game is finished or not
	 * @return true if the game is finished and false otherwise
	 */
	public boolean gameIsFinished() {
		return gameIsLost() || gameIsWon();
	}
	
	/**
	 * tells if the game is lost, you lost if you are in the trap room 
	 * @return true is the game is lost 
	 */
	public boolean gameIsLost() {
		return this.player.getRoom().getClass() == TrapRoom.class;
	}
	
	/**
	 * tells if the game is won, you won if you are in the exit room
	 * @return true is the game is won
	 */
	public boolean gameIsWon() {
		return this.player.getRoom().getClass() == ExitRoom.class;
	}
	
	/**
	 * do what the player want to do
	 * @param command the command of the player
	 */
	public void interpretCommand(String command) {
		Room currentRoom = this.player.getRoom();
		
		if (command.startsWith("go ")) {
			move(command.substring(3),currentRoom);
		}
		else {
			System.out.println("I don't know what you mean !");
		}
		System.out.println("-------------------------------------------------------");
	}
	
	/**
	 * moves a player in the room with the desired direction if it's possible
	 * @param direction the desired direction
	 * @param currentRoom the current room of the player
	 */
	public void move(String direction,Room currentRoom) {
		for (Direction d : Direction.values()) {
			if (d.toString().equals(direction)) {
				if (currentRoom.getNeighbors().containsKey(direction)) {
					this.player.setRoom(currentRoom.getNeighbor(direction));
				}
				else {
					System.out.println("Can't go "+direction);
				}
			}
		}	
	}
	
	/**
	 * gives the description of a game and the commands
	 * @return the description
	 */
	public String getGameDescription() {
		String s = "Welcome in the Dungeon!\n"
				+ "The rules are simple, you have to progress in the dungeon to find the exit.\n"
				+ "The commands are : go north, go south, go east and go west.";
		return s;
				
	}

	
	
}
