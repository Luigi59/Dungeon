package dungeon.objects;

public abstract class Item {

	private String nameObject;
	 
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
	
	public abstract String getType();
}
