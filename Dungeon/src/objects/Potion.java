package objects;

public class Potion extends Item {

	private int hpWin;
	
	/**
	 * a potion
	 * @param name the name of the potion
	 * @param hpWin the health points win with the potion
	 */
	public Potion(String name, int hpWin) {
		super(name);
		this.hpWin = hpWin;
	}
	
	/**
	 * gives the number of health points win with the potion
	 * @return the number of HP win
	 */
	public int getHpWin() {
		return this.hpWin;
	}
	
	@Override
	public String getDescription() {
		return "It's a potion that restores "+this.hpWin+" health point(s)";
	}

	@Override
	public String getType() {
		return "potion";
	}
}
