package dungeon;

public class Character {
	
	protected int health;
	protected int maxHealth;
	protected int attack;
	
	/**
	 * a character
	 * @param health the number of health points
	 * @param attack the number of attack points
	 */
	public Character(int health, int attack) {
		this.health = health;
		this.maxHealth = health;
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
	 * @param health the new number of health points
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * gives the maximum number of health points
	 * @return the number of max health points
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	
	/**
	 * Tells if the character is dead or not.
	 * @return true if the character is dead and false if not
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
