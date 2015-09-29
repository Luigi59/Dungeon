package entity;

import objects.Item;

public class Chest {
	
	protected Item item;
	
	/**
	 * a chest with a item inside
	 * @param item
	 */
	public Chest(Item item) {
		this.item = item;
	}

	/**
	 * open a chest and return the item
	 * @return the item that is in the chest
	 */
	public Item open() {
		Item res = null;
		if(item == null)
			System.out.println("The chest is empty.");
		else {
			System.out.println("You found " + item.getName());
			System.out.println(item.getDescription());
			res = item;
			item = null;
		}
		return res;
	}
	
}
