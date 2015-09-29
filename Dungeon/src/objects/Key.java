package objects;

import dungeon.Room;

public class Key extends Item {

	protected Room room;
	
	/**
	 * a key
	 * @param name the name of the key
	 * @param room the room that the key unlocks
	 */
	public Key(String name, Room room) {
		super(name);
		this.room = room;
	}
	
	@Override
	public String getDescription() {
		return "It's a key that opens a locked room";
	}

	@Override
	public String getType() {
		return "key";
	}
	
	/**
	 * gives the room when the key is
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}
	
}
