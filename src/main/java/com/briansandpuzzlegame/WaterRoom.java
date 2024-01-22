package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import org.json.JSONObject;

public class WaterRoom implements IRoom {
	CommandParser p;
	StateTracker z;
	JTextArea textBox;

	String userInput;
	ArrayList<String> inventory;

	/*
	 * poolState = 0, pool is empty poolState = 1, pool is level with stairs.
	 * Starting level poolState = 2, pool is flooding over onto platform
	 */

	int poolState = 1;

	boolean door = false;

	public WaterRoom(CommandParser p) {
		this.p = p;
	}

	@Override
	public void verbInterpreter() throws IOException {
		userInput = p.inputPasser();

		if (userInput.contains("enter"))
			enter();

		if (userInput.contains("go"))
			go();

		if (userInput.contains("push"))
			push();

		if (userInput.contains("open"))
			open();

		if (userInput.contains("close"))
			close();

		if (userInput.contains("move"))
			move();

		if (userInput.contains("walk"))
			walk();

		if (userInput.contains("use"))
			use();

		if (userInput.contains("turn"))
			turn();

		if (userInput.contains("take"))
			take();

		if (userInput.contains("inspect"))
			inspect();

		if (userInput.contains("put"))
			put();

		if (userInput.contains("place"))
			place();

		if (userInput.contains("remove"))
			remove();

		if (userInput.contains("attack"))
			attack();

		if (userInput.contains("climb"))
			climb();

		if (userInput.contains("hide"))
			hide();

		if (userInput.contains("descend"))
			descend();

		if (userInput.contains("run"))
			run();

		if (userInput.contains("jump"))
			jump();

		if (userInput.contains("search"))
			search();

		if (userInput.contains("investigate"))
			investigate();

		if (userInput.contains("look"))
			look();

		if (userInput.contains("check"))
			check();

		if (userInput.contains("touch"))
			touch();

		if (userInput.contains("throw"))
			Throw();

		if (userInput.contains("watch"))
			watch();

		if (userInput.contains("wait"))
			Wait();

		if (userInput.contains("break"))
			Break();

		if (userInput.contains("smash"))
			smash();

		if (userInput.contains("north"))
			north();

		if (userInput.contains("east"))
			east();

		if (userInput.contains("south"))
			south();

		if (userInput.contains("west"))
			west();

		if (userInput.contains("yes"))
			yes();

		if (userInput.contains("no"))
			no();

		if (userInput.contains("exit"))
			exit();

		if (userInput.contains("repeat"))
			repeat();

		if (userInput.contains("inventory"))
			inventory();

		if (userInput.contains("spyglass"))
			spyglass();

		if (userInput.contains("load"))
			/*
			 * try { z = new StateTracker(); load(z); } catch (InstantiationException |
			 * IllegalAccessException | ClassNotFoundException | IOException e) {
			 * e.printStackTrace(); }
			 */

			if (userInput.contains("save")) {
				z = new StateTracker();
				save(z);
			}

		if (userInput.contains("continue"))
			Continue();

	}

	@Override
	public void firstTimeRun() {
		inventory = new ArrayList<String>();

		textBox.append("\n The stairwell opens up to a huge room"
				+ "\n The ceiling is lined with metal pipes weaving every which way"
				+ "\n The far end of the room overlooks a huge pool of water"
				+ "\n There are stairs that lead down into the water"
				+ "\n In the center of the room is a pedastel with the top slanted");

	}

	@Override
	public void setParser(CommandParser p) {
		this.p = p;
	}

	@Override
	public void enter() {
		textBox.append("\n I do not understand where you want to go");
	}

	@Override
	public void push() {

		switch (userInput) {

		case "pedastel":
			textBox.append("\n It does not move");

		case "green":
			if (poolState == 0) {
				textBox.append("\n You hear the sound of a pipe opening"
						+ "\n The pool rapidally floods up to level with the stairs");
				poolState = 1;
			} else if (poolState == 1) {
				textBox.append("\n You hear the sound of a pipe opening"
						+ "\n The water level rapidally rises, spilling over onto the platform"
						+ "\n You are now standing in a few feet of water");
				poolState = 2;
			} else {
				textBox.append("\n Nothing happens");
			}

		case "red":
			if (poolState == 1) {
				textBox.append("\n A pipe opens up on the far side of the pool"
						+ "\n The water rapidally begins to drain down the pipe"
						+ "\n After 30 seconds the pool is entirely drained"
						+ "\n The pipe closes when the pool is drained");
				poolState = 0;
			} else if (poolState == 2) {
				textBox.append("\n A pipe opens on the far side of the pool"
						+ "\n The water drops back to level with the stairs down");
				poolState = 1;
			} else if (poolState == 0) {
				textBox.append("\n A pipe opens up on the far side of the now empty pool"
						+ "\n After a few seconds it closes");
			}

		case "blue":
			if (door == false) {
				textBox.append("\n A large door slides open on the far left wall of the pool");
				if (poolState == 2) {
					textBox.append("\n The door is level with the water level");
				} else if (poolState == 1 || poolState == 2) {
					textBox.append("\n The door is above the water level");
				}
				door = true;
			} else {
				textBox.append("\n The door slides shut");
			}

		}
	}

	@Override
	public void go() {
		textBox.append("\n I do not understand where you want to go");
	}

	@Override
	public void open() {
		textBox.append("\n I do not understand what you want to open");
	}

	@Override
	public void close() {
		textBox.append("\n I do not understand what you want to close");
	}

	@Override
	public void move() {
		if (userInput.contains("pedestal")) {
			textBox.append("\n The pedestal is fixed to the ground");
		}
	}

	@Override
	public void walk() {
		textBox.append("\n I do not understand where you want to walk");
	}

	@Override
	public void use() {
		if (userInput.contains("hammer")) {
			textBox.append("\n I do not understand what you want to use the hammer on");
		} else {
			textBox.append("\n I do not understand what you want to use");
		}
	}

	@Override
	public void turn() {
		textBox.append("\n I do not understand what you want to turn");
	}

	@Override
	public void take() {
		textBox.append("\n I do not understand what you want to take");
	}

	@Override
	public void inspect() {
		if (userInput.contains("pedastel")) {
			textBox.append("\n The pedastel is about a chest height"
					+ "\n On the pedastel are three buttons: one green, one red, and one blue");
		} else if (userInput.contains("room")) {
			textBox.append("\n Nothing else of note appears to be in this room");
		} else if (userInput.contains("water") || userInput.contains("pool")) {
			textBox.append("\n The water is dark and murky. You cannot see the botom");
		} else if (userInput.contains("pipes") || userInput.contains("ceiling")) {
			textBox.append("\n You notice one pipe that appears to have handles built into it incrementally");
		} else {
			textBox.append("\n I do not understand what you want to inspect");
		}
	}

	@Override
	public void investigate() {
		if (userInput.contains("pedastel")) {
			textBox.append("\n The pedastel is about a chest height"
					+ "\n On the pedastel are three buttons: one green, one red, and one blue");
		} else if (userInput.contains("room")) {
			textBox.append("\n Nothing else of note appears to be in this room");
		} else if (userInput.contains("water") || userInput.contains("pool")) {
			textBox.append("\n The water is dark and murky. You cannot see the botom");
		} else if (userInput.contains("pipes") || userInput.contains("ceiling")) {
			textBox.append("\n You notice one pipe that appears to have handles built into it incrementally");
		} else {
			textBox.append("\n I do not understand what you want to investigate");
		}
	}

	@Override
	public void attack() {

	}

	@Override
	public void climb() {
		if (userInput.contains("pipe") || userInput.contains("pipes")) {
			
		}
		
		
		textBox.append("\n I do not understand what you want to climb");
	}

	@Override
	public void descend() {

	}

	@Override
	public void run() {
		textBox.append("\n You run. Congratulations.");
	}

	@Override
	public void hide() {
		textBox.append("\n Who are you hiding from? Idiot.");
	}

	@Override
	public void crawl() {
		textBox.append("\n I do not understand where you want to crawl");
	}

	@Override
	public void jump() {
		if (userInput.contains("water") && poolState == 0) {
			textBox.append("\n You go to jump into the water when you remember something:" + "\n You cannot swim.");
		} else {
			textBox.append("\n I do not understand where you want to jump to");
		}
	}

	@Override
	public void search() {
		if (userInput.contains("pedastel")) {
			textBox.append("\n The pedastel is about a chest height"
					+ "\n On the pedastel are three buttons: one green, one red, and one blue");
		} else if (userInput.contains("room")) {
			textBox.append("\n Nothing else of note appears to be in this room");
		} else if (userInput.contains("water") || userInput.contains("pool")) {
			textBox.append("\n The water is dark and murky. You cannot see the botom");
		} else {
			textBox.append("\n I do not understand what you want to search");
		}
	}

	@Override
	public void look() {

	}

	@Override
	public void check() {

	}

	@Override
	public void touch() {

	}

	@Override
	public void Throw() {

	}

	@Override
	public void watch() {

	}

	@Override
	public void Wait() {

	}

	@Override
	public void Break() {

	}

	@Override
	public void smash() {

	}

	@Override
	public void put() {

	}

	@Override
	public void place() {

	}

	@Override
	public void remove() {

	}

	@Override
	public void inventory() {

	}

	@Override
	public void north() {

	}

	@Override
	public void east() {

	}

	@Override
	public void south() {

	}

	@Override
	public void west() {

	}

	@Override
	public void yes() {

	}

	@Override
	public void no() {

	}

	@Override
	public void leave() {

	}

	@Override
	public void exit() {

	}

	@Override
	public void spyglass() {

	}

	@Override
	public void Continue() {

	}

	@Override
	public void repeat() {
		textBox.append("\n You find yourself at one end of this long room"
				+ "\n The walls are lined with human-like head statues, placed equally apart"
				+ " \n In the center of the room is a stone pedastel with the top slanted");

	}

	@Override
	public void save(StateTracker z) {

	}

	@Override
	public void load(StateTracker z)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

	}

	@Override
	public void loadCall(JSONObject params) {

	}

	@Override
	public ArrayList<String> getInventory() {
		return inventory;
	}

	@Override
	public void setInventory(ArrayList<String> inventory) {
		this.inventory = inventory;
	}

	@Override
	public void setTextBox(JTextArea textBox) {
		this.textBox = textBox;
	}

}
