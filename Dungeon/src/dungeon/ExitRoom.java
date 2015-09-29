package dungeon;


public class ExitRoom extends Room{

	/**
	 * A exit room
	 */
	public ExitRoom() {
		super();
	}
	
	@Override
	public boolean canBeLeft() {
		return true;
	}
	
	@Override
	public String getDescription() {
		return "the exit!";
	}
}
