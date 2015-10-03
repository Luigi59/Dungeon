package dungeon;


public class NormalRoom extends Room {

	/**
	 * A normal room
	 */
	public NormalRoom() {
		super();
	}
	
	/**
	 * A normal room
	 * @param locked true if the room is locked false if not
	 */
	public NormalRoom(boolean locked) {
		super(locked);
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
