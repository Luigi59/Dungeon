package dungeon;

/** A player in the game Dungeon */
public class Player {

	private String name;
	
	private int healthPoints;
	
	private Room currentRoom;
	
	/**
	 * 
	 * @param name the name of the player
	 * @param HP the number of health points of the player
	 */
	public Player(String name,int HP) {
		this.name = name;
		this.healthPoints = HP;
		this.currentRoom = null;
	}
	
	/**
	 * gives the number of health points
	 * @return the number of health points
	 */
	public int getHealthPoints() {
		return this.healthPoints;
	}
	
	/**
	 * changes the health points of the player
	 * @param HP the new number of health points
	 * @throws PlayerDeadException
	 */
	public void setHealthPoints(int HP) throws PlayerDeadException {
		if (HP <= 0) {
			throw new PlayerDeadException("The player is dead.\n");
		}
		else {
		this.healthPoints = HP;
		}
	}
	
	/**
	 * gives the current Room of the player
	 * @return the current Room of the player
	 */
	public Room getRoom() {
		return this.currentRoom;
	}
	
	/**
	 * changes the Room of the player
	 * @param newRoom the new Room
	 */
	public void setRoom(Room newRoom) {
		this.currentRoom = newRoom;
	}
	
	/**
	 * gives a description of the player
	 * @return the description of the player
	 */
	public String toString() {
		String s = "Your name is : "+this.name+"\nNumber of health points : "+this.healthPoints;
		return s;
	}
}
