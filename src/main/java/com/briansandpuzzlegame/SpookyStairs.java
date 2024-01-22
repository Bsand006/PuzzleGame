package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import org.json.JSONObject;

public class SpookyStairs implements IRoom {
	CommandParser p;
	StateTracker z;

	String userInput;
	ArrayList<String> inventory;
	JTextArea textBox;
	
	// Level checks
	
	boolean spyglass = false;
	boolean wallUp = false;
	
	public SpookyStairs(CommandParser p) {
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
		 textBox.append("\n You walk up this spiral staircase for a few seconds until you come face to face"
				+ "\n with a stone wall.");

	}

	@Override
	public void setParser(CommandParser p) {
		this.p = p;
	}

	@Override
	public void enter() {

	}

	@Override
	public void push() {
		if (userInput.contains("wall") || userInput.contains("stone")) {
			 textBox.append("\n The wall does not budge");
		}
		
		if (userInput.contains("button") && spyglass == true) {
			 textBox.append("\n The wall rumbles as it slowly retracts into the floor");
			wallUp = true;
		}

	}

	@Override
	public void go() {

	}

	@Override
	public void open() {
		if (userInput.contains("wall") || userInput.contains("stone")) {
			 textBox.append("\n The wall does not budge");
		}

	}

	@Override
	public void close() {

	}

	@Override
	public void move() {
		if (userInput.contains("wall") || userInput.contains("stone")) {
			 textBox.append("\n The wall does not budge");
		}

	}

	@Override
	public void walk() {

	}

	@Override
	public void use() {

	}

	@Override
	public void turn() {

	}

	@Override
	public void take() {

	}

	@Override
	public void inspect() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n It is a solid stone wall");
		}
	}

	@Override
	public void investigate() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n It is a solid stone wall");
		}
	}

	@Override
	public void attack() {

	}

	@Override
	public void climb() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n The wall reaches the ceiling");
		}

	}

	@Override
	public void descend() {

	}

	@Override
	public void run() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void crawl() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n The wall reaches the floor");
		}

	}

	@Override
	public void jump() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n The wall reaches the ceiling");
		}

	}

	@Override
	public void search() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n It is a solid stone wall");
		}
	}

	@Override
	public void look() {

	}

	@Override
	public void check() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n It is a solid stone wall");
		}
	}

	@Override
	public void touch() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n The stone is cold to the touch");
		}
	}

	@Override
	public void Throw() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n Wall too big :(");
		}

	}

	@Override
	public void watch() {

	}

	@Override
	public void Wait() {

	}

	@Override
	public void Break() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n Wall too big :(");
		}
	}

	@Override
	public void smash() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n Wall too big :(");
		}
	}

	@Override
	public void put() {

	}

	@Override
	public void place() {

	}

	@Override
	public void remove() {
		if (userInput.contains("stone") || userInput.contains("wall")) {
			 textBox.append("\n Wall too big :(");
		}
	}

	@Override
	public void inventory() {
		if (!inventory.isEmpty()) {
			 textBox.append("\n" + inventory);
		} else {
			 textBox.append("\n Inventory is empty");
		}
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
		if (userInput.contains("wall") || userInput.contains("stone")) {
			 textBox.append("\n You put the spyglass up to your eye"
					+ "\n A glowing green button appears in the center of the wall");
		}
	}

	@Override
	public void Continue() {
		if (wallUp == true) {
			 textBox.append("\n The stairs continue upward for ten more steps"
					+ "\n They open up to a large rectangular room");
			p.level.setText("com.briansandpuzzlegame.WaterRoom");
		}

	}

	@Override
	public void repeat() {

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
