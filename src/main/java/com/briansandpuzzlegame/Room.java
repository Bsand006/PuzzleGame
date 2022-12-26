package com.briansandpuzzlegame;

import java.util.ArrayList;
import java.util.List;

public class Room implements IRoom {
	CommandParser p;

	String userInput;
	String playerLocation;
	List<String> playerState = new ArrayList<String>();
	List<String> inventory = new ArrayList<String>();

	boolean plateopen = false;

	public Room(CommandParser p) {
		this.p = p;
	}

	public void verbInterpreter() {

		userInput = p.inputPasser();
		System.out.println(userInput);

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

		// Plate on wall
		if (playerState.contains("foundPlate") && plateopen == false) {
			p.textBox.append("\n The plate is firmly screwed into place");

		} else if (playerState.contains("foundPlate") && plateopen == true) {
			p.textBox.append("\n You remove the plate and find a key inside" + "\n Plate key added to inventory");
			inventory.add("key from plate");

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
	}

	public void turn() {
	}

	public void take() {
		if (userInput.contains("hammer") && playerLocation.equals("east")) {
			p.textBox.append("\n You take the hammer");
			inventory.add("hammer");

		} else {
			p.textBox.append("\n I do not understand what you want to take");
		}
	}

	public void inspect() {
		if (userInput.contains("object") && !playerState.contains("inspectedObject")) {

			p.textBox.append("\n You run your hand along its metallic surface and you feel a button");
			playerState.add("inspectedObject");

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
		if (userInput.contains("lightswitch")) {
			p.textBox.append("\n You search the walls for a lightswitch and do not find one");

		} else {
			p.textBox.append("\n I do not understand what you are searching for");
		}

		if (userInput.contains("room") && playerState.contains("pushedButton")) {
			p.textBox.append("\n You search the entire room" + "\n You find a metal panel attached by four screws");

			playerState.add("foundPlate");
		}

	}

	public void look() {
		if (userInput.contains("left")) {
			p.textBox.append("\n You look left and see complete darkness");
		} else if (userInput.contains("right")) {
			p.textBox.append("\n You look right and see complete darkness");

		} else {
			p.textBox.append("\n I do not understand where you are looking");
		}
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
	}

	public void smash() {
	}

	public void inventory() {

		if (!inventory.isEmpty()) {
			p.textBox.append("\n" + inventory);
		} else {
			p.textBox.append("\n Inventory is empty");
		}
	}

	public void north() {
		if (!playerLocation.equals("north") && playerState.contains("pushedButton")) {
			p.textBox.append("\n The metal door has two keyholes. The handle is retracted into the door");

			playerLocation = "north";

		} else if (playerLocation.equals("north")) {
			p.textBox.append("\n You are a north as you can go");
		}
	}

	public void east() {
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
