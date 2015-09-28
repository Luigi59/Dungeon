package dungeon;

public class Main {
	
	public static void main(String[] args) {
		Player p1 = new Player(10);
		Dungeon d1 = new Dungeon(1);
		Game game = new Game(d1,p1);
	
		game.start();
	}
	
}
