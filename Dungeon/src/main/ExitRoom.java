package main;


public class ExitRoom extends Room{

	/**
	 * @param exitPosition the position of the room
	 */
	public ExitRoom() {
		;
	}
	
	/**
	 * tells if a player can leaves the room
	 * @return <tt>true</tt> if and only if the player in this room can freely
	 *  leaves the room
	 */
	public boolean canBeLeft() {
		return true;
	}
	
	/**
	 * gives the type of the room
	 * @return the description of the room
	 */
	public String getDescription() {
		return "This is the exit!";
	}
}
