package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dungeon.NormalRoom;
import dungeon.Room;
import entity.Button;

public class ButtonTest {
	
	Room r1;
	Room r2;
	Button b;
	
	@Before
	public void createButton() {
		r1 = new NormalRoom();
		r2 = new NormalRoom(true);
		r1.addNeighbor("north", r2);
		r2.addNeighbor("south", r1);
		b = new Button(r2);
		r1.setButton(b);
	}

	@Test
	public void testActivate() {
		assertTrue(r2.isLocked());
		r1.getButton().activate();
		assertFalse(r2.isLocked());
		r1.getButton().activate();
		assertFalse(r2.isLocked());
	}

}
