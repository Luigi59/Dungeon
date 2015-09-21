package dungeon.objects;

public class Potion extends Object {

	private int hpWin;
	
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
	public String toString() {
		return "It's a potion that makes you win "+this.hpWin+" health point(s)";
	}
}
