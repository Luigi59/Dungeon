package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import entity.Button;
import entity.Chest;
import objects.Item;
import objects.Key;
import objects.Potion;

public class Game {

	private Player player;
	
	private Dungeon dungeon;
	
	/**
	 * a game 
	 * @param dungeon the dungeon
	 * @param player the player who are in the dungeon
	 */
	public Game(Dungeon dungeon, Player player) {
		this.dungeon = dungeon;
		this.player = player;
		Room entrance = this.dungeon.getRoomWithNumber(1);
		this.player.setRoom(entrance);
	}
	
	/**
	 * start the game
	 */
	public void start() {
		System.out.println(getGameDescription());
		do {
			if(player.isInFight()) {
				System.out.println(player.toString());
				System.out.println("You are fighting " + player.getRoom().getMonster().toString() + ".");
				System.out.println("You can fight or use potion.");
			} else
				System.out.println("You are in "+ this.player.getRoom().getFullDescription());
			System.out.println("What do you want to do?");
			System.out.print("> ");
			
			String line = dungeon.scanner.nextLine();
			interpretCommand(line);
		} while (!gameIsFinished());
		if (gameIsWon()) {
			System.out.println("You win!");
		} else {
			System.out.println("You loose!");
		}
	}
	
	/**
	 * tells if the game is finished or not
	 * @return true if the game is finished and false otherwise
	 */
	public boolean gameIsFinished() {
		return gameIsLost() || gameIsWon();
	}
	
	/**
	 * tells if the game is lost, you lost if you are dead
	 * @return true is the game is lost 
	 */
	public boolean gameIsLost() {
		return this.player.isDead();
	}
	
	/**
	 * tells if the game is won, the player win if you are in the exit room
	 * @return true is the game is won
	 */
	public boolean gameIsWon() {
		return this.player.getRoom().getClass() == ExitRoom.class;
	}
	
	/**
	 * do what the player want to do
	 * @param command the command of the player
	 */
	public void interpretCommand(String command) {
		Room currentRoom = this.player.getRoom();
		
		if(command.equals("fight"))
			fight();
		else if(command.equals("open chest"))
			openChest();
		else if(command.equals("push button"))
			pushButton();
		else if(command.equals("inventory"))
			inventory();
		else if(command.equals("description"))
			description();
		else if(command.startsWith("use "))
				useItem(command.substring(4));
		else if (command.startsWith("go ")) {
			move(command.substring(3),currentRoom);
		}
		else {
			System.out.println("I don't know what you mean !");
		}
		System.out.println("-------------------------------------------------------");
	}
	
	/**
	 * moves a player in the room with the desired direction if it's possible
	 * @param direction the desired direction
	 * @param currentRoom the current room of the player
	 */
	public void move(String direction,Room currentRoom) {
		for (Direction d : Direction.values()) {
			if (d.toString().equals(direction)) {
				if (currentRoom.getNeighbors().containsKey(direction) && currentRoom.getMonster() == null) {
					if(currentRoom.getNeighbor(direction).isLocked())
						System.out.println("Can't go " + direction + ", the room is locked.");
					else {
						this.player.setRoom(currentRoom.getNeighbor(direction));
						System.out.println("You go " + direction + ".");
						if(player.getRoom().getClass() == TrapRoom.class) {
							System.out.println("Ouch ! You lost 2 health points.");
							player.setHealth(player.getHealth() - 2);
						}
						if(player.getRoom().getMonster() != null)
							System.out.println(player.getRoom().getMonster().getName() + " is guarding the room.");
					}
				}
				else {
					System.out.println("Can't go "+ direction + "!");
					if(currentRoom.getMonster() != null)
						System.out.println("You are currently fighting !");
				}
			}
		}	
	}
	
	/**
	 * fight with a monster
	 */
	public void fight() {
		if(!player.isInFight())
			System.out.println("There is nothing to fight.");
		else {
			Monster monster = player.getRoom().getMonster();
			monster.setHealth(monster.getHealth() - player.getAttack());
			if(!monster.isDead())
				player.setHealth(player.getHealth() - monster.getAttack());
			else {
				player.getRoom().setMonster(null);
				System.out.println("You defeated " + monster.getName() + ".");
			}
		}
	}
	
	/**
	 * open a chest and if there is a item, add the item to the inventory of the player 
	 */
	public void openChest() {
		if(player.isInFight())
			System.out.println("You can't do that during a fight.");
		else {
			Chest chest = player.getRoom().getChest();
			if(chest == null)
				System.out.println("There is no chest in this room.");
			else {
				Item item = chest.open();
				if(item != null)
					try {
						player.addItem(item);
					} catch (ItemDoesNotExist e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
	
	/**
	 * push a button
	 */
	public void pushButton() {
		if(player.isInFight())
			System.out.println("You can't do that during a fight.");
		else {
			Button button = player.getRoom().getButton();
			if(button == null)
				System.out.println("There is no button in this room.");
			else
				button.activate();
		}
	}
	
	/**
	 * gives the inventory of the player
	 */
	public void inventory() {
		if(player.isInFight())
			System.out.println("You can't do that during a fight.");
		else
			System.out.println(player.getInventory());
	}
	
	/**
	 * gives the description of a player
	 */
	public void description() {
		if(player.isInFight())
			System.out.println("You can't do that during a fight.");
		else
			System.out.println(player.toString());
	}
	
	/**
	 * use a item
	 * @param str the type of the item
	 */
	public void useItem(String str) {
		switch(str) {
		// potion
		case "potion":
			if(!player.getBag().containsKey("potion") || player.getBag().get("potion") == null)
				System.out.println("You have no potion.");
			else {
				if(player.getHealth() == player.getMaxHealth())
					System.out.println("Your health points are already to the maximum.");
				else {
					Potion p = (Potion) player.getBag().get("potion");
					player.drinkPotion(p);
				}
			}
			break;
		// key
		case "key":
			if(player.isInFight())
				System.out.println("You can't do that during a fight.");
			else {
				if(player.getKeys().size() < 1) 
					System.out.println("You have no key.");
				else {
					List<Key> usedKeys = new ArrayList<Key>();
					Map<String, Room> neighbors = player.getRoom().getNeighbors();
					for(int i=0; i<player.getKeys().size(); ++i) {
						for(Entry<String, Room> entry : neighbors.entrySet()) {
							if(entry.getValue().equals(player.getKeys().get(i).getRoom())) {
								System.out.println("You use a key to unlock the room to the " + entry.getKey() + ".");
								entry.getValue().unlock();
								usedKeys.add(player.getKeys().get(i));
								break;
							}
						}
					}
					for(int i=0; i<usedKeys.size(); ++i)
						player.getKeys().remove(usedKeys.get(i));
					if(usedKeys.size() < 1)
						System.out.println("None of your keys can be used here.");
				}
			}
			break;
		default: System.out.println("The item \"" + str + "\" does not exist."); break;
		}
	}
	
	/**
	 * gives the description of a game and the commands
	 * @return the description
	 */
	public String getGameDescription() {
		String s = "Welcome in the Dungeon!\n"
				+ "The rules are simple, you have to progress in the dungeon to find the exit.\n"
				+ "The commands for the direction are : go north, go south, go east and go west.\n"
				+ "The other commands are : open chest, fight, use (+the name of the item), push button, description and inventory.\n"
				+ "----------------------------------------------------------------------------------------------";
		return s;
				
	}

	
	
}
