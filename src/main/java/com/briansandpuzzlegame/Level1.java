package com.briansandpuzzlegame;

import java.util.ArrayList;
import java.util.List;

public class Level1 implements IRoom {
	CommandParser p;

	String userInput;
	String playerLocation = "center";
	List<String> playerState = new ArrayList<String>();
	List<String> inventory = new ArrayList<String>();



	public Level1(CommandParser p) {
		this.p = p;
	}

	public void doorOpens() {

		p.textBox.append(
				"\n The door squeaks as it swings open" + "\n You have completed level 1! Type 'continue' to move on");

		if (userInput.contains("continue"))
			p.level += 1;

	}

	public void verbInterpreter() {

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
		
	}

	public void enter() {
		
	}

	public void go() {
		if (userInput.contains("foward") && !playerState.contains("movedFoward")) {
			p.textBox.append("\n You move into the room and bump into some object");
			playerState.add("movedFoward");

		} else {
			p.textBox.append("\n I do not understand where you are trying go");
		}
	}

	public void push() {

		if (userInput.contains("button") && playerState.contains("inspectedObject")
				&& !playerState.contains("pushedButton")) {

			p.textBox.append("\n You push the button. The room floods with bright light"
					+ "\n You stand in a large square room made of concrete"
					+ "\n There is a metal door to the north. There is a table to the east");

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
		if (userInput.contains("foward") && !playerState.contains("movedFoward")) {
			p.textBox.append("\n You move into the room and bump into some object");
			playerState.add("movedFoward");

		} else {
			p.textBox.append("\n I do not understand where you are trying to move to");
		}
	}

	public void use() {
		if (inventory.contains("screwdriver") && userInput.contains("panel")) {
			p.textBox.append("\n You unscrew the panel and it clatters to the ground" + "\n There is a key inside");
			playerState.add("openedPanel");

		} else if (inventory.contains("key") && playerLocation.equals("north") && userInput.contains("door")) {
			p.textBox.append("\n The key slides into the lock and the handle pops out of the door"
					+ "\n The door is still locked");
			playerState.add("tableKeyUsed");

			if (playerState.contains("tableKeyUsed") && playerState.contains("buttonKeyUsed"))
				doorOpens();

		} else if (inventory.contains("buttonKey") && playerLocation.equals("north") && userInput.contains("door")) {
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

		} else if (playerState.contains("foundScrewdriver") && playerLocation.equals("east")) {
			p.textBox.append("\n You take the screwdriver");
			inventory.add("screwdriver");

		} else if (playerState.contains("openedPanel")) {
			p.textBox.append("\n You take the key");
			inventory.add("key");

		} else if (playerState.contains("pushedButtonTwice")) {
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
	}

	public void touch() {
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
		
		} else {
			p.textBox.append("\n I do not understand what you want to break");
		}
	}

	public void smash() {

		if (inventory.contains("hammer") && userInput.contains("table") && playerLocation.equals("east")
				&& !inventory.contains("screwdriver")) {
			p.textBox.append("\n You smash the table with the hammer" + "\n You find a screwdriver in the debris");
		
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

	public void south() {
	}

	public void west() {
	}

	public void yes() {
	}

	public void no() {
	}
}
