package dungeon;

public class NormalRoom extends Room {

	public NormalRoom() {
		super();
	}
	
	@Override
	public boolean canBeLeft() {
		return true;
	}
	
	@Override
	public String getDescription() {
		return " It's an intersection.";
	}
}
