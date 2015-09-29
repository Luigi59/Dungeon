package objects;

import dungeon.Room;

public class Key extends Item {

	protected Room room;
	
	public Key(String name, Room room) {
		super(name);
		this.room = room;
	}
	
	public String getDescription() {
		return "It's a key that opens a locked room";
	}

	public String getType() {
		return "key";
	}
	
	public Room getRoom() {
		return room;
	}
	
}
