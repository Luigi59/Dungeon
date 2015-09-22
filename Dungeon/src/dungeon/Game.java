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
		do {
			System.out.println("You are in "+ this.player.getRoom().getDescription());
			System.out.println("What do you want to do?");
			System.out.print("> ");
			
			String line = dungeon.scanner.nextLine();
			dungeon.interpretCommand(line);
		} while (!gameIsFinished());
		System.out.println("You are in "+ this.player.getRoom().getDescription());
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
		Room trap = new TrapRoom();
		return this.player.getRoom().equals(trap);
	}
	
	/**
	 * tells if the game is won, you won if you are in the exit room
	 * @return true is the game is won
	 */
	public boolean gameIsWon() {
		Room exit = new ExitRoom();
		return this.player.getRoom().equals(exit);
	}
	
	
}
