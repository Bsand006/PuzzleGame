package com.briansandpuzzlegame;

import java.util.ArrayList;
import java.util.List;

public class EastDoorPuzzle implements IRoom {
	CommandParser p;

	String userInput;
	boolean[] locks = new boolean[4];
	List<String> inventory = new ArrayList<String>();

	public EastDoorPuzzle(CommandParser p) {
		this.p = p;
	}

	@Override
	public void verbInterpreter() {

		userInput = p.inputPasser();

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
	}

	@Override
	public void enter() {

	}

	@Override
	public void push() {

		if (userInput.contains("box")) {
			p.textBox.append("\n The box is bolted to the pedastel it rests on");

		} else {
			p.textBox.append("\n I do not understand what you want to push");
		}
	}

	@Override
	public void go() {

	}

	@Override
	public void open() {
		if (userInput.contains("box") && locks[0] == true && locks[1] == true && locks[2] == true && locks[3] == true) {
			p.textBox.append("\n The lid of the box creaks open");
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
	public void use() {
		// TODO Auto-generated method stub

	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void take() {

		switch (userInput) {

		case "take keys":

			if (!inventory.contains("key1") && !inventory.contains("key2") && !inventory.contains("key3")
					&& !inventory.contains("key4")) {

				p.textBox.append("\n You take all four keys");

			} else {
				p.textBox.append("\n You aready have the keys");
			}

			break;

		case "take key":
			p.textBox.append("\n Which key do you take? Key 1, 2, 3, or 4?");
			break;

		case "take key 1":

			if (!inventory.contains("key1")) {
				p.textBox.append("\n You take the 1st key");
				inventory.add("key1");
			} else {
				p.textBox.append("\n You already have the 1st key");
			}
			break;

		case "take key 2":

			if (!inventory.contains("key2")) {
				p.textBox.append("\n You take the 2nd key");
				inventory.add("key2");
			} else {
				p.textBox.append("\n You already have the 2nd key");
			}
			break;

		case "take key 3":

			if (!inventory.contains("key3")) {
				p.textBox.append("\n You take the 3rd key");
				inventory.add("key3");
			} else {
				p.textBox.append("\n You already have the 3rd key");
			}
			break;

		case "take key 4":

			if (!inventory.contains("key4")) {
				p.textBox.append("\n You take the 4th key");
				inventory.add("key4");
			} else {
				p.textBox.append("\n You aleady have the 4th key");
			}
			break;

		case "box":
			p.textBox.append("\n The box is fixed to the pedestal");

		default:
			p.textBox.append("\n I do not understand what you want to take");
			break;

		}

	}

	@Override
	public void inspect() {

		if (userInput.contains("box")) {
			p.textBox.append("\n The images above the locks on the box are: ");
			p.textBox.append("\n    Bat, Snake, Spider, Wolf");

		} else if (userInput.contains("keys")) {
			p.textBox.append("\n The number of teeth on the keys are: ");
			p.textBox.append("\n    Five, Four, Six, Three");

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
	public void search() {

		if (userInput.contains("room")) {
			p.textBox.append("\n There is nothing else in this room of interest");
		} else {
			p.textBox.append("\n I do not understand what you want to search");
		}
	}

	@Override
	public void look() {
		// TODO Auto-generated method stub

	}

	@Override
	public void check() {
		// TODO Auto-generated method stub

	}

	@Override
	public void touch() {

		if (userInput.contains("box")) {
			p.textBox.append("\n The metallic box is cold to the touch");
		} else {
			p.textBox.append("\n I do not understand what you want to touch");
		}
	}

	@Override
	public void Throw() {

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
	public void Break() {

		if (userInput.contains("box")) {
			p.textBox.append("\n Its a heavy metal box... you fail to break it");

		} else {
			p.textBox.append("\n I do not understand what you want to break");
		}
	}

	@Override
	public void smash() {

		if (userInput.contains("box")) {
			p.textBox.append("\n Its a heavy metal box... you fail to smash it");

		} else {
			p.textBox.append("\n I do not understand what you want to smash");
		}
	}

	@Override
	public void inventory() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	public void yes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void no() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Continue() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getInventory() {

		return inventory;
	}

	@Override
	public void setInventory(List<String> inventory) {

		this.inventory = inventory;
	}

}
