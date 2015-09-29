package entity;

import objects.Item;

public class Chest {
	
	protected Item item;
	
	public Chest(Item item) {
		this.item = item;
	}

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
