package dungeon;

public class Monster {

	private String name;
	private int healthPoints;
	private int attackPoints;
	private boolean alive;
	
	public Monster(int hp, int attackPoints) {
		this.healthPoints = hp;
		this.attackPoints = attackPoints;
		this.name = "Monster";
		this.alive = true;
	}
	
	/**
	 * gives the number of health points
	 * @return the number of health points
	 */
	public int getHealthPoints() {
		return this.healthPoints;
	}
	
	/**
	 * changes the health points of the monster
	 * @param hp the new number of health points
	 */
	public void setHealthPoints(int hp) {
		if (hp <=0) {
			this.healthPoints = 0;
			setAlive(false);
		}
		else {
			this.healthPoints = hp;
		}
	}
	
	/**
	 * tells if a monster is alive or not
	 * @return true if the monster is alive and false if not
	 */
	public boolean isALive() {
		return this.alive;
	}
	
	/**
	 * changes the state of live of the monster
	 * @param alive state of life
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/**
	 * gives the name of the monster
	 * @return the name 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * gives the number of attack points of the monster
	 * @return the number of attack points
	 */
	public int getAttackPoints() {
		return this.attackPoints;
	}
}

