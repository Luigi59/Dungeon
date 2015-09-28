package dungeon;

public class Character {
	
	protected int health;
	protected int maxHealth;
	protected int attack;
	
	public Character(int health, int attack) {
		this.health = health;
		maxHealth = health;
		this.attack = attack;
	}
	
	/**
	 * gives the number of health points
	 * @return the number of health points
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * changes the health points of the character
	 * @param HP the new number of health points
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * Tells if the character is dead or not.
	 * @return boolean
	 */
	public boolean isDead() {
		return health <= 0;
	}
	
	/**
	 * gives the number of attack points of the character
	 * @return the number of attack points
	 */
	public int getAttack() {
		return attack;
	}

}
