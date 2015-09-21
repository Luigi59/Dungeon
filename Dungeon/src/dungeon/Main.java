package dungeon;

public class Main {
	
	public static void main(String[] args) {
		/*Player p1 = new Player("Estelle",10);
		System.out.println(p1.getHealthPoints());
		System.out.println(p1.toString());
		try {
			p1.setHealthPoints(0);
		}
		catch (PlayerDeadException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(p1.getHealthPoints());
		
		Position p = new Position(1,1);
		Room r2 = new TrapRoom(p);
		
		System.out.println(r2.canBeLeft());
		System.out.println(r2.getDescription());*/
		new Dungeon(1);
	}
	
}
