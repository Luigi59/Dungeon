package dungeon;


public class NormalRoom extends Room {

	/**
	 * A normal room
	 */
	public NormalRoom() {
		super();
	}
	
	@Override
	public boolean canBeLeft() {
		return true;
	}
	
	@Override
	public String getDescription() {
		return "an intersection.";
	}
}
