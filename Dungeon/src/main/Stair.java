package main;


public class Stair {
	
	private Room entrance;
	private boolean exitExist = false;
	private int number;
	
	public Stair() {
		entrance = new Room(number);
	}
}
