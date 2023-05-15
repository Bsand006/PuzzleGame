package com.briansandpuzzlegame;

/*
 * This room is past the door to the east in the GreatDoor room. This room contains a puzzle box
 * that holds a piece of paper which has part of the sequence to open the great door.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class EastDoorPuzzle implements IRoom {
	CommandParser p;
	StateTracker z;

	String userInput;
	boolean[] locks = new boolean[4]; // Position of the four locks on the box. Are they unlocked or not?
	boolean boxUnlock = false; // Is the box unlocked?
	boolean leaveRoom = false; // Leave the room?
	List<String> inventory = new ArrayList<String>(); // Inventory

	public EastDoorPuzzle(CommandParser p) {
		this.p = p;

		setInventory(inventory); // Updates inventory from previous class
	}
	
	@Override
	public void firstTimeRun() {
		
	}

	@Override // Executes verb methods
	public void verbInterpreter() throws IOException {

		userInput = p.inputPasser();

		if (userInput.contains("repeat"))
			repeat();

		if (userInput.contains("inspect"))
			inspect();

		if (userInput.contains("break"))
			Break();

		if (userInput.contains("smash"))
			smash();

		if (userInput.contains("use"))
			use();

		if (userInput.contains("take"))
			take();

		if (userInput.contains("open"))
			open();

		if (userInput.contains("push"))
			push();

		if (userInput.contains("search"))
			search();

		if (userInput.contains("touch"))
			touch();

		if (userInput.contains("throw"))
			Throw();

		if (userInput.contains("inventory"))
			inventory();

		if (userInput.contains("look"))
			look();

		if (userInput.contains("check"))
			check();

		if (userInput.contains("west"))
			west();

		if (userInput.contains("leave"))
			leave();

		if (userInput.contains("exit"))
			exit();

		if (userInput.contains("go"))
			go();

		if (userInput.contains("yes"))
			yes();

		if (userInput.contains("no"))
			no();

		if (userInput.contains("load"))
			z = new StateTracker();
			try {
				load(z);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}

		if (userInput.contains("save"))
			save(null);
	}

	public void boxUnlocks() { // Alerts player when the puzzle is completed

		if (locks[0] == true && locks[1] == true && locks[2] == true && locks[3] == true) {
			p.textBox.append("\n You hear the latches inside the box click");
			boxUnlock = true;

		}

	}

	@Override
	public void enter() {

	}

	@Override
	public void push() { // Player tried to push the box or pedastel over?

		if (userInput.contains("box")) {
			p.textBox.append("\n The box is bolted to the pedastel it rests on");

		} else if (userInput.contains("pedastel")) {
			p.textBox.append("\n The pedastel is bolted to the floor");
		} else {
			p.textBox.append("\n I do not understand what you want to push");
		}

	}

	@Override
	public void go() {

		if (userInput.contains("west")) {
			p.textBox.append("\n Do you want to leave the room? Yes or no");
			leaveRoom = true;
		}
	}

	@Override
	public void open() { // Player tries to open the box?
		if (boxUnlock == true) {
			p.textBox.append("\n The lid of the box creaks open");
			p.textBox.append("Inside there is a single sheet of paper and a key");
		} else if (boxUnlock == false) {
			p.textBox.append("\n The box is locked");
		} else {
			p.textBox.append("\n I do not understand what you want to open");
		}

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void use() { // Player uses the keys on a lock?

		if (userInput.contains("key") && userInput.contains("lock")) {

			switch (userInput) {

			case "use first key on second lock":
				if (locks[1] == false && inventory.contains("key1")) {

					p.textBox.append("\n You hear a click as the key turns the lock");
					locks[1] = true;
					inventory.remove(inventory.indexOf("key1"));
					boxUnlocks();

				} else if (!inventory.contains("key1")) {
					p.textBox.append("\n You do not have the first key in your inventory");
				}

				break;

			case "use second key on fourth lock":
				if (locks[3] == false && inventory.contains("key2")) {

					p.textBox.append("\n You hear a click as the key turns the lock");
					locks[3] = true;
					inventory.remove(inventory.indexOf("key2"));
					boxUnlocks();

				} else if (!inventory.contains("key2")) {
					p.textBox.append("\n You do not have the second key in your inventory");
				}

				break;

			case "use third key on third lock":
				if (locks[2] == false && inventory.contains("key3")) {

					p.textBox.append("\n You hear a click as the key turns the lock");
					locks[2] = true;
					inventory.remove(inventory.indexOf("key3"));
					boxUnlocks();

				} else if (!inventory.contains("key3")) {
					p.textBox.append("You do not have the third key in your inventory");
				}

				break;

			case "use fourth key on first lock":
				if (locks[0] == false && inventory.contains("key4")) {

					p.textBox.append("\n You hear a click as the key turns the lock");
					locks[0] = true;
					inventory.remove(inventory.indexOf("key4"));
					boxUnlocks();

				} else if (!inventory.contains("key4")) {
					p.textBox.append("\n You do not have the fourth key in your inventory");
				}

				break;

			case "use key 1 on lock 2":
				if (locks[1] == false && inventory.contains("key1")) {

					p.textBox.append("\n You hear a click as the key turns the lock");
					locks[1] = true;
					inventory.remove(inventory.indexOf("key1"));
					boxUnlocks();

				} else if (!inventory.contains("key1")) {
					p.textBox.append("\n You do not have the first key in your inventory");
				}

				break;

			case "use key 2 on lock 4":
				if (locks[3] == false && inventory.contains("key2")) {

					p.textBox.append("\n You hear a click as the key turns the lock");
					locks[3] = true;
					inventory.remove(inventory.indexOf("key2"));
					boxUnlocks();

				} else if (!inventory.contains("key2")) {
					p.textBox.append("\n You do not have the second key in your inventory");
				}

				break;

			case "use key 3 on lock 3":
				if (locks[2] == false && inventory.contains("key3")) {

					p.textBox.append("\n You hear a click as the key turns the lock");
					locks[2] = true;
					inventory.remove(inventory.indexOf("key3"));
					boxUnlocks();

				} else if (!inventory.contains("key3")) {
					p.textBox.append("You do not have the third key in your inventory");
				}

				break;

			case "use key 4 on lock 1":
				if (locks[0] == false && inventory.contains("key4")) {

					p.textBox.append("\n You hear a click as the key turns the lock");
					locks[0] = true;
					inventory.remove(inventory.indexOf("key4"));
					boxUnlocks();

				} else if (!inventory.contains("key4")) {
					p.textBox.append("\n You do not have the fourth key in your inventory");
				}

				break;

			default:
				p.textBox.append("\n The key shoots out of the lock as you stick it in");

			}

		} else {
			p.textBox.append("\n I do not understand what you want to use");
		}
	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void take() { // Player takes a key?

		switch (userInput) {

		case "take keys":

			if (!inventory.contains("key1") && !inventory.contains("key2") && !inventory.contains("key3")
					&& !inventory.contains("key4")) {

				p.textBox.append("\n You take all four keys");
				inventory.add("key1");
				inventory.add("key2");
				inventory.add("key3");
				inventory.add("key4");

			} else {
				p.textBox.append("\n You aready have the keys");
			}

			break;

		case "take key":
			p.textBox.append("\n Which key do you take? Key 1, 2, 3, or 4?");
			break;

		case "take key 1":

			if (!inventory.contains("key1") && locks[1] == false) {
				p.textBox.append("\n You take the 1st key");
				inventory.add("key1");
			} else {
				p.textBox.append("\n You already have the 1st key");
			}
			break;

		case "take key 2":

			if (!inventory.contains("key2") && locks[3] == false) {
				p.textBox.append("\n You take the 2nd key");
				inventory.add("key2");
			} else {
				p.textBox.append("\n You already have the 2nd key");
			}
			break;

		case "take key 3":

			if (!inventory.contains("key3") && locks[2] == false) {
				p.textBox.append("\n You take the 3rd key");
				inventory.add("key3");
			} else {
				p.textBox.append("\n You already have the 3rd key");
			}
			break;

		case "take key 4":

			if (!inventory.contains("key4") && locks[0] == false) {
				p.textBox.append("\n You take the 4th key");
				inventory.add("key4");
			} else {
				p.textBox.append("\n You aleady have the 4th key");
			}
			break;

		case "box":
			p.textBox.append("\n The box is fixed to the pedestal");

		case "paper":

			if (boxUnlock == true) {
				p.textBox.append("\n You take the paper");
				inventory.add("paper");
			}

		default:
			p.textBox.append("\n I do not understand what you want to take");
			break;

		}

	}

	@Override
	public void inspect() { // Player inspects the box, locks, or the keys?

		if (userInput.contains("box")) {
			p.textBox.append("\n The images above the locks on the box are: ");
			p.textBox.append("\n    Bat, Snake, Spider, Wolf");

		} else if (userInput.contains("keys")) {
			p.textBox.append("\n First key has Five, second has Four, third has Six, " + "fourth has Three");

		} else if (userInput.contains("locks")) {
			p.textBox.append("\n The images above the locks on the box are: ");
			p.textBox.append("\n    Bat, Snake, Spider, Wolf");
		} else {
			p.textBox.append("\n I do not understand what you want to inspect");
		}
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void climb() {
		// TODO Auto-generated method stub

	}

	@Override
	public void descend() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void crawl() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub

	}

	@Override
	public void search() { // Player searches room?

		if (userInput.contains("room")) {
			p.textBox.append("\n There is nothing else in this room of interest");
		} else {
			p.textBox.append("\n I do not understand what you want to search");
		}
	}

	@Override
	public void look() { // Player looks at box, locks, or keys?

		if (userInput.contains("box")) {
			p.textBox.append("\n The images above the locks on the box are: ");
			p.textBox.append("\n    Bat, Snake, Spider, Wolf");

		} else if (userInput.contains("keys")) {
			p.textBox.append("\n First key has Five, second has Four, third has Six, " + "fourth has Three");

		} else if (userInput.contains("locks")) {
			p.textBox.append("\n The images above the locks on the box are: ");
			p.textBox.append("\n    Bat, Snake, Spider, Wolf");
		} else {
			p.textBox.append("\n I do not understand what you want to look at");
		}

	}

	@Override
	public void check() { // Player checks the room?

		if (userInput.contains("room")) {
			p.textBox.append("\n There is nothing else in this room of interest");
		} else {
			p.textBox.append("\n I do not understand what you want to check");
		}
	}

	@Override
	public void touch() { // Player touches box?

		if (userInput.contains("box")) {
			p.textBox.append("\n The metallic box is cold to the touch");
		} else {
			p.textBox.append("\n I do not understand what you want to touch");
		}
	}

	@Override
	public void Throw() { // Player tries to throw box or pedestal?

		if (userInput.contains("box")) {
			p.textBox.append("\n The box is bolted to the pedestal");
		} else if (userInput.contains("pedestal")) {
			p.textBox.append("\n The pedestal is bolted to the floor");
		} else {
			p.textBox.append("\n I do not understand what you want to throw");
		}

	}

	@Override
	public void watch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Wait() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Break() { // Player tries to break box?

		if (userInput.contains("box")) {
			p.textBox.append("\n Its a heavy metal box... you fail to break it");

		} else {
			p.textBox.append("\n I do not understand what you want to break");
		}
	}

	@Override
	public void smash() { // Player tries to smash box?

		if (userInput.contains("box")) {
			p.textBox.append("\n Its a heavy metal box... you fail to smash it");

		} else {
			p.textBox.append("\n I do not understand what you want to smash");
		}
	}

	@Override
	public void inventory() { // Show inventory

		if (!inventory.isEmpty()) {
			p.textBox.append("\n" + inventory);
		} else {
			p.textBox.append("\n Inventory is empty");
		}
	}

	@Override
	public void north() {
		// TODO Auto-generated method stub

	}

	@Override
	public void east() {
		// TODO Auto-generated method stub

	}

	@Override
	public void south() {
		// TODO Auto-generated method stub

	}

	@Override
	public void west() {

		p.textBox.append("\n Do you want to leave this room? Yes or no");
		leaveRoom = true;
	}

	@Override
	public void yes() {

		if (leaveRoom == true) {
			p.textBox.append("\n You leave the room");
			getInventory();
			p.activeLevel = "Great door";
		} else {
			p.textBox.append("\n What?");
		}

	}

	@Override
	public void no() {

		if (leaveRoom == true) {
			p.textBox.append("\n You decide not to leave the room");
			leaveRoom = false;
		} else {
			p.textBox.append("\n What?");
		}
	}

	@Override
	public void Continue() {

	}

	@Override
	public List<String> getInventory() {

		return inventory;
	}

	@Override
	public void setInventory(List<String> inventory) {

		this.inventory = inventory;
	}

	@Override
	public void leave() {

		if (userInput.contains("room")) {
			p.textBox.append("\n Do you want to leave the room? Yes or no");
			leaveRoom = true;
		}
	}

	@Override
	public void exit() {

		if (userInput.contains("room")) {
			p.textBox.append("\n Do you want to exit the room? Yes or no");
			leaveRoom = true;
		}
	}

	@Override
	public void save(StateTracker z) {
		JSONObject eastDoor = new JSONObject();
		eastDoor.put("activeLevel", "com.briansandpuzzlegame.EastDoorPuzzle");

		JSONArray playerInv = new JSONArray();
		playerInv.put(1, inventory);
		eastDoor.put("Inv", playerInv);

		JSONArray boxLocks = new JSONArray();

		for (int i = 0; i < locks.length; i++) {
			boxLocks.put(i, locks[i]);
		}

		eastDoor.put("locks", boxLocks);
		eastDoor.put("boxUnlock?", boxUnlock);

		p.textBox.append("\n Game saved");
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub

	}

	@Override
	public void repeat() {
		p.textBox.append("\n ");
		p.textBox.append("\n In the center of this room sits a small metal box on " + "a pedastal");
		p.textBox.append("\n There is an iron lock on all four sides. Each lock has a " + "scuplted image above it");
		p.textBox.append("\n Four keys hang from the wall, all with different numbers of teeth");
		p.textBox.append("\n Above the keys the following verse is etched into the wall:");
		p.textBox.append("\n ");
		p.textBox.append("\n    The spells of these locks are all the same");
		p.textBox.append("\n     Though each possesses a unique name");
		p.textBox.append("\n    Count on your answer to unlock the way");
		p.textBox.append("\n     But use the wrong key to your dismay");

	}

	@Override
	public void investigate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void put() {
		// TODO Auto-generated method stub

	}

	@Override
	public void place() {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(StateTracker z)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		p.textBox.append("\n LOADING...");
		z.load();
	}

	@Override
	public void loadCall(JSONObject params) {
		JSONObject paramaters = params;
		inventory = (List<String>) paramaters.get("Inv");
		
		for (int i = 0; i < locks.length; i++) {
		}

	}

}
