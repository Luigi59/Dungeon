package main;


public class TrapRoom extends Room {

	/**
	 * @param trapPosition the position of the room
	 */
	public TrapRoom() {
	;
	}
	
	/**
	 * tells if a player can leaves the room
	 * @return <tt>true</tt> if and only if the player in this room can freely
	 *  leaves the room
	 */
	public boolean canBeLeft() {
		return false;
	}
	
	/**
	 * gives the type of the room
	 * @return the description of the room
	 */
	public String getDescription() {
		return "It's a trap!";
	}
}
