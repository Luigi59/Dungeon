package objects;

public class Weapon extends Item {
	
	private int damage;
	
	/**
	 * a weapon
	 * @param name the name of the weapon
	 * @param damage the damage of the weapon
	 */
	public Weapon(String name, int damage) {
		super(name);
		this.damage = damage;
	}

	/**
	 * gives the number of damage of the weapon
	 * @return the number of damage
	 */
	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public String getDescription() {
		return "It's a weapon with "+this.damage+" damage(s)";
	}

	@Override
	public String getType() {
		return "weapon";
	}
}
