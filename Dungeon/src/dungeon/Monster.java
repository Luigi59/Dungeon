package dungeon;

public class Monster extends Character {

	private String name;
	
	/**
	 * a monster
	 * @param name the name of the monster
	 * @param health the number of health points of the monster
	 * @param attack the number of attack points of the monster
	 */
	public Monster(String name, int health, int attack) {
		super(health, attack);
		this.name = name;
	}
	
	/**
	 * gives the name of the monster
	 * @return the name  of the monster
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * gives the description of a monster
	 */
	public String toString() {
		return getName() + " (HP : " + getHealth() + "/" + maxHealth + " ; ATK : " + getAttack() + ")";
	}
}

