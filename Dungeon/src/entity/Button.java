package entity;

import dungeon.Room;

public class Button {
	
	protected Room linkedRoom;
	
	/**
	 * A button unlocks a room (given in parameter) in the dungeon
	 * @param room
	 */
	public Button(Room linkedRoom) {
		this.linkedRoom = linkedRoom;
	}
	
	public void activate() {
		if(!linkedRoom.isLocked())
			System.out.println("This button has already been activated.");
		else {
			linkedRoom.unlock();
			System.out.println("You pushed the button and heard a mechanism in the dungeon.");
		}
	}

}
