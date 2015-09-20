package main;


public class Player {

	private String name;
	
	private int healthPoints;
	
	private Room currentRoom;
	
	public Player(String name,int HP) {
		this.name = name;
		this.healthPoints = HP;	
	}
	
	public int getHealthPoints() {
		return this.healthPoints;
	}
	
	public void setHealthPoints(int HP) throws PlayerDeadException {
		if (HP <= 0) {
			throw new PlayerDeadException("The player is dead.\n");
		}
		else {
		this.healthPoints = HP;
		}
	}
	
	public Room getRoom() {
		return this.currentRoom;
	}
	
	public void setRoom(Room newRoom) {
		this.currentRoom = newRoom;
	}
	
	public String toString() {
		return "Your name is : "+this.name+"\nNumber of health points : "+getHealthPoints();
	}
}
