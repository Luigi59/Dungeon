package dungeon;

public class Monster extends Character {

	private String name;
	
	public Monster(String name, int health, int attack) {
		super(health, attack);
		this.name = name;
	}
	
	/**
	 * gives the name of the monster
	 * @return the name 
	 */
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return getName() + " (HP : " + getHealth() + "/" + maxHealth + " ; ATK : " + getAttack() + ")";
	}
}

