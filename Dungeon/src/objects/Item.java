package objects;

public abstract class Item {

	private String nameObject;
	 
	/**
	 * a abstract item
	 * @param nameObject the name of the item
	 */
	public Item(String nameObject) {
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
	public abstract String getDescription();
	
	/**
	 * gives the type of the item
	 * @return the type
	 */
	public abstract String getType();
}
