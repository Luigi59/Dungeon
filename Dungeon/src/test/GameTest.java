package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import dungeon.ExitRoom;
import dungeon.Game;
import dungeon.Player;

public class GameTest {

	private Dungeon dungeon1;
	private Player p1;
	private Player p2;
	private Game game;
	private ExitRoom exit;
	
	@Before
	public void createGame() {
		exit = new ExitRoom();
		dungeon1 = new Dungeon(1);
		p1 = new Player(10);
		p2 = new Player(5);
		game = new Game(dungeon1,p1);	
	}
	
	@Test 
	public void TestGameIsLost() {
		p1.setHealth(0);
		assertTrue(game.gameIsLost());
	}
	
	@Test
	public void TestGameIsWon() {
		p1.setRoom(exit);
		assertTrue(game.gameIsWon());
	}
	
	@Test
	public void testGameIsFinished() {
		p1.setRoom(exit);
		assertTrue(game.gameIsFinished());
		p2.setHealth(0);
		assertTrue(game.gameIsFinished());
	}
	
	@Test
	public void testGetGameDescription() {
		String s = "Welcome in the Dungeon!\n"
				+ "The rules are simple, you have to progress in the dungeon to find the exit.\n"
				+ "The commands for the direction are : go north, go south, go east and go west.\n"
				+ "The other commands are : open chest, fight, use (+the name of the item), push button, description and inventory.\n"
				+ "----------------------------------------------------------------------------------------------";
		assertEquals(s, game.getGameDescription());
	}
}
