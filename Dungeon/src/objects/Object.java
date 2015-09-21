package dungeon.objects;

public abstract class Object {

	private String nameObject;
	
	public Object(String nameObject) {
		this.nameObject = nameObject;
	}
	
	/**
	 * gives the name of the object
	 * @return the name of the object
	 */
	public String getName() {
		return this.nameObject;
	}
	
	/**
	 * gives the description of the object
	 * @return the description of the object
	 */
	public abstract String toString();
}
