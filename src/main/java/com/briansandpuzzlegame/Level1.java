package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level1 implements IRoom {
	CommandParser p;

	StateTracker z;
	String userInput;
	String playerLocation = "center";
	List<String> inventory = new ArrayList<String>();
	List<String> playerState = new ArrayList<String>();

	public Level1(CommandParser p) {
		this.p = p;

	}

	// Interpreter
	public void verbInterpreter() throws IOException {

		userInput = p.inputPasser();
		System.out.println(userInput);

		if (userInput.contains("break"))
			Break();

		if (userInput.contains("inventory"))
			inventory();

		if (userInput.contains("look"))
			look();

		if (userInput.contains("move"))
			move();

		if (userInput.contains("go"))
			go();

		if (userInput.contains("walk"))
			walk();

		if (userInput.contains("search"))
			search();

		if (userInput.contains("inspect"))
			inspect();

		if (userInput.contains("push"))
			push();

		if (userInput.contains("east"))
			east();

		if (userInput.contains("north"))
			north();

		if (userInput.contains("south"))
			south();

		if (userInput.contains("west"))
			west();

		if (userInput.contains("open"))
			open();

		if (userInput.contains("take"))
			take();

		if (userInput.contains("use"))
			use();

		if (userInput.contains("look"))
			look();

		if (userInput.contains("continue"))
			Continue();

		if (userInput.contains("load"))
			load();

		if (userInput.contains("save"))
			z = new StateTracker();
			save(z);

		if (userInput.contains("touch"))
			touch();

		if (userInput.contains("check"))
			check();
	}

	// Level completion method
	public void doorOpens() {

		p.textBox.append(
				"\n The door squeaks as it swings open" + "\n You have completed level 1! Type 'continue' to move on");

	}

	public void enter() {

	}

	public void go() {
		if (userInput.contains("forward") && !playerState.contains("movedForward")) {
			p.textBox.append("\n You go into the room and bump into some object");
			playerState.add("movedForward");

		} else if (userInput.contains("left") && !playerState.contains("movedForward")) {
			p.textBox.append("\n You bump into a wall");

		} else if (userInput.contains("right") && !playerState.contains("movedForward")) {
			p.textBox.append("\n You bump into a wall");
		} else {
			p.textBox.append("\n I do not understand where you are trying to go to");
		}
	}

	public void push() {

		if (userInput.contains("button") && playerState.contains("inspectedObject")
				&& !playerState.contains("pushedButton")) {

			p.textBox.append("\n You push the button. The room floods with bright light"
					+ "\n You stand in a large square room made of concrete"
					+ "\n There is a metal door to the north. There is a table to the east"
					+ "\n Along the east wall there is a small patch of it that seems different");

			playerState.add("pushedButton");
			playerLocation = "center";

		} else if (userInput.contains("button") && playerState.contains("pushedButton")
				&& !inventory.contains("buttonKey")) {

			p.textBox.append("\n You decide to push the button again" + "\n Out of the plate the "
					+ "button is on a key is revealed");
			playerState.add("pushedButtonTwice");

		} else {
			p.textBox.append("\n I do not understand what you are trying to push");
		}

	}

	public void open() {

		// Drawer on table
		if (userInput.contains("drawer") && playerLocation.equals("east")) {
			p.textBox.append("\n The drawer appears to be empty");

		} else {
			p.textBox.append("\n I do not understand what you want to open");
		}

	}

	public void close() {
	}

	public void move() {
		if (userInput.contains("forward") && !playerState.contains("movedForward")) {
			p.textBox.append("\n You move into the room and bump into some object");
			playerState.add("movedForward");

		} else if (userInput.contains("left") && !playerState.contains("movedForward")) {
			p.textBox.append("\n You bump into a wall");

		} else if (userInput.contains("right") && !playerState.contains("movedForward")) {
			p.textBox.append("\n You bump into a wall");
		} else {
			p.textBox.append("\n I do not understand where you are trying to move to");
		}

	}

	public void walk() {
		if (userInput.contains("forward") && !playerState.contains("movedForward")) {
			p.textBox.append("\n You walk into the room and bump into some object");
			playerState.add("movedForward");

		} else if (userInput.contains("left") && !playerState.contains("movedForward")) {
			p.textBox.append("\n You bump into a wall");

		} else if (userInput.contains("right") && !playerState.contains("movedForward")) {
			p.textBox.append("\n You bump into a wall");
		} else {
			p.textBox.append("\n I do not understand where you are trying to walk to");
		}

	}

	public void use() {
		if (inventory.contains("screwdriver") && userInput.contains("panel")) {
			p.textBox.append("\n You unscrew the panel and it clatters to the ground" + "\n There is a key inside");
			playerState.add("openedPanel");

		} else if (inventory.contains("key") && playerLocation.equals("north") && userInput.contains("door")
				&& !playerState.contains("tableKeyUsed")) {

			p.textBox.append("\n The key slides into the lock and the handle pops out of the door"
					+ "\n The door is still locked");
			playerState.add("tableKeyUsed");

			if (playerState.contains("tableKeyUsed") && playerState.contains("buttonKeyUsed"))
				doorOpens();

		} else if (inventory.contains("buttonKey") && playerLocation.equals("north") && userInput.contains("door")
				&& !playerState.contains("buttonKeyUsed")) {

			p.textBox.append("\n The key slides into the lock" + "\n The latch mechanicaly slides open");
			playerState.add("buttonKeyUsed");

			if (playerState.contains("tableKeyUsed") && playerState.contains("buttonKeyUsed"))
				doorOpens();

		} else {
			p.textBox.append("\n I do not understand what you want to use");
		}

	}

	public void turn() {
	}

	public void take() {
		if (userInput.contains("hammer") && playerLocation.equals("east")) {
			p.textBox.append("\n You take the hammer");
			inventory.add("hammer");

		} else if (playerState.contains("foundScrewdriver") && playerLocation.equals("east")
				&& !inventory.contains("screwdriver")) {

			p.textBox.append("\n You take the screwdriver");
			inventory.add("screwdriver");

		} else if (userInput.contains("key") && playerState.contains("openedPanel") && !inventory.contains("key")) {
			p.textBox.append("\n You take the key");
			inventory.add("key");

		} else if (playerState.contains("pushedButtonTwice") && !inventory.contains("buttonKey")) {
			p.textBox.append("\n You take the key");
			inventory.add("buttonKey");

		} else {
			p.textBox.append("\n I do not understand what you want to take");
		}
	}

	public void inspect() {
		if (userInput.contains("object") && !playerState.contains("inspectedObject")) {

			p.textBox.append("\n You run your hand along its metallic surface and you feel a button");
			playerState.add("inspectedObject");

		} else if (userInput.contains("drawer") && playerLocation.equals("east")) {
			p.textBox.append("\n You run your hand along the inside of the drawer"
					+ "\n You feel a small panel. You push it and it retracts to reveal a screwdriver");
			playerState.add("foundScrewdriver");

		} else if (userInput.contains("wall") && playerLocation.equals("east")) {
			p.textBox.append("You find a metal panel attached by four screws");
			playerState.add("foundPlate");

		} else {
			p.textBox.append("\n I do not understand what you are inspecting");
		}
	}

	public void attack() {
	}

	public void climb() {
	}

	public void hide() {
	}

	public void descend() {
	}

	public void crawl() {
	}

	public void run() {
	}

	public void jump() {
	}

	public void search() {

		// If user looks for lightswitch
		if (userInput.contains("lightswitch")) {
			p.textBox.append("\n You search the walls for a lightswitch and do not find one");

			// Searching room after lights are on
		} else if (userInput.contains("room") && playerState.contains("pushedButton")) {
			p.textBox.append("\n You search the entire room" + "\n You find a metal panel attached by four screws");

			playerState.add("foundPlate");

			// Unrecognized input
		} else {
			p.textBox.append("\n I do not understand what you are searching for");
		}

	}

	public void look() {

	}

	public void check() {
		if (userInput.contains("wall") && playerLocation.equals("east")) {
			p.textBox.append("You find a metal panel attached by four screws");
			playerState.add("foundPlate");
		} else {
			p.textBox.append("\n I do not understand what you want to check");
		}

	}

	public void touch() {
		if (userInput.contains("object") && !playerState.contains("inspectedObject")) {

			p.textBox.append("\n You run your hand along its metallic surface and you feel a button");
			playerState.add("inspectedObject");

		} else {
			p.textBox.append("\n I do not understand what you are touching");
		}

	}

	public void Throw() {
	}

	public void watch() {
	}

	public void Wait() {
	}

	public void Break() {

		if (inventory.contains("hammer") && userInput.contains("table") && playerLocation.equals("east")
				&& !inventory.contains("screwdriver")) {
			p.textBox.append("\n You smash the table with the hammer" + "\n You find a screwdriver in the debris");
			playerState.add("foundScrewdriver");

		} else {
			p.textBox.append("\n I do not understand what you want to break");
		}
	}

	public void smash() {

		if (inventory.contains("hammer") && userInput.contains("table") && playerLocation.equals("east")
				&& !inventory.contains("screwdriver")) {
			p.textBox.append("\n You smash the table with the hammer" + "\n You find a screwdriver in the debris");
			playerState.add("foundScrewdriver");
		} else {
			p.textBox.append("\n I do not understand what you want to smash");
		}
	}

	public void inventory() {

		// Displays inventory
		if (!inventory.isEmpty()) {
			p.textBox.append("\n" + inventory);
		} else {
			p.textBox.append("\n Inventory is empty");
		}
	}

	public void north() {

		// Metal door
		if (!playerLocation.equals("north") && playerState.contains("pushedButton")) {
			p.textBox.append("\n The metal door has two keyholes and a latch. The handle is retracted into the door"
					+ "\n The latch cannot be moved by hand");

			playerLocation = "north";

		} else if (playerLocation.equals("north")) {
			p.textBox.append("\n You are a north as you can go");
		}
	}

	public void east() {

		// Table
		if (!playerLocation.equals("east") && playerState.contains("pushedButton")) {
			p.textBox.append("\n The table is made of wood and has a drawer" + "\n On the table is a hammer");

			playerLocation = "east";

		} else if (playerLocation.equals("east"))
			p.textBox.append("\n You are as east as you can go");
	}

	public void Continue() { // MOVES TO NEXT LEVEL

		getInventory();
		p.activeLevel = "Great door";
		p.textBox.setText("");
		p.textBox.append("You step into a large room");
		p.textBox.append("\n To the north is a large door 20ft tall");
		p.textBox.append("\n There are 5 pedastals in a row in front of the door");
		p.textBox.append("\n To the east there is a small wood door");
		p.textBox.append("\n To the west there is another door");
		p.textBox.append("\n A small metal box lies on a table in the room");
	}

	public void south() {

		if (!playerLocation.equals("south") && playerState.contains("pushedButton")) {
			if (playerLocation.equals("north")) {
				p.textBox.append("\n You are at the stand with the button in the center");
				playerLocation = "center";
			}
		} else if (playerLocation.equals("south"))
			p.textBox.append("\n You are as south as you can go");
	}

	public void west() {
	}

	public void yes() {
	}

	public void no() {
	}

	@Override
	public void leave() {
	}

	@Override
	public void exit() {
	}

	@Override
	public void repeat() {

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
	public void save(StateTracker z) {

		String room = p.activeLevel;
		z.setCurrentRoom(room);
		z.setInventory(inventory);
		z.setPlayerState(playerState);
		
		try {
			z.save();
		} catch (IOException e) {
			e.printStackTrace();
		}

		p.textBox.append("\n Game saved");

	}

	@Override
	public void load() {

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
}
