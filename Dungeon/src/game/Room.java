package game;

import java.util.HashMap;
import java.util.Map;

public class Room {
	
	protected String type;
	protected Map<String, String> neighbors;
	
	public Room(String type) {
		this.type = type;
		neighbors = new HashMap<String, String>();
		neighbors.put("north", null);
		neighbors.put("west", null);
	}

}
