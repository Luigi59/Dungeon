package dungeon;


public class TrapRoom extends Room {

	public TrapRoom() {
		super(); 
	}
	
	@Override
	public boolean canBeLeft() {
		return false;
	}
	
	@Override
	public String getDescription() {
		return "It's a trap!";
	}
}
