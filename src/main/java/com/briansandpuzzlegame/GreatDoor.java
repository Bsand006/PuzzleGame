package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import org.json.JSONArray;
import org.json.JSONObject;

public class GreatDoor implements IRoom {
	CommandParser p;

	StateTracker z;
	String userInput;
	String playerLocation = "center";
	ArrayList<String> inventory;
	JTextArea textBox;

	// Game checks

	boolean eastDoorComplete = false;
	boolean westDoorComplete = false;
	boolean stairs = false;

	@Override
	public void setParser(CommandParser p) {
		this.p = p;
	}

	public GreatDoor(CommandParser p) {
		this.p = p;
	}

	@Override
	public void firstTimeRun() {
		inventory = new ArrayList<String>();

		 textBox.setText("");
		 textBox.append("You step into a large room");
		 textBox.append("\n To the north is a large door 20ft tall");
		 textBox.append("\n There are 5 pedastals in a row in front of the door");
		 textBox.append("\n To the east there is a small wood door");
		 textBox.append("\n To the west there is another door");
		 textBox.append("\n A small metal box lies on a table in the room");

	}

	public void doorCheck() {
		if (eastDoorComplete == true && westDoorComplete == true) {
			 textBox.append("\n The east and west doors swing shut"
					+ "\n Part of the wall slides down to reveal a staircase going up");
			stairs = true;

		}
	}

	@Override
	public void verbInterpreter() {

		userInput =  p.inputPasser();
		System.out.println(userInput);

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
			;
		repeat();

		if (userInput.contains("inventory"))
			inventory();

		if (userInput.contains("load"))
			try {
				z = new StateTracker();
				load(z);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}

		if (userInput.contains("save")) {
			z = new StateTracker();
			save(z);
		}

		if (userInput.contains("continue"))
			Continue();

	}

	@Override
	public void enter() {

	}

	@Override
	public void push() {

	}

	@Override
	public void go() {

		switch (userInput) {

		case "stairs":
			if (stairs == true) {

			}

		case "east":
			if (playerLocation.equals("center")) {
				playerLocation = "eastDoor";
				 textBox.append("");
				 textBox.append("\n You stand before a wooden door");

			} else if (playerLocation.equals("westDoor")) {
				playerLocation = "center";
				 textBox.append("\n You are in front of the large door in the center");
				if (inventory.contains("westDoorPyramid")) {
					westDoorComplete = true;
					doorCheck();
				}
			} else {
				 textBox.append("\n You are as east as you can go");
			}

		case "west":
			if (playerLocation.equals("center")) {
				playerLocation = "westDoor";
				 textBox.append("\n You stand in front of an unassuming door");

			} else if (playerLocation.equals("eastDoor")) {
				playerLocation = "center";
				 textBox.append("\n You are in front of the large door in the center");
				if (inventory.contains("eastDoorPyramid")) {
					eastDoorComplete = true;
					doorCheck();
				}
			} else {
				 textBox.append("\n You are as west as you can go");
			}

		}
	}

	@Override
	public void open() {

		if (userInput.contains("door") && playerLocation.equals("eastDoor")) {
			if (eastDoorComplete == false) {
				playerLocation = "puzzleBox";
				 p.level.setText("com.briansandpuzzlegame.EastDoorPuzzle");
			} else {
				 textBox.append("\n There is nothing more to do in there");
			}

		} else if (userInput.contains("door") && playerLocation.equals("westDoor")) {
			if (westDoorComplete == false) {
				playerLocation = "West door";
				 p.level.setText("com.briansandpuzzlegame.WestDoorPuzzle");

			}

		} else if (userInput.contains("box") && userInput.contains("key")) {
			if (inventory.contains("westRoomKey")) {
				 textBox.append("\n The box opens to reveal a small spyglass"
						+ "\n There is a note that reads : Use the spyglass to reveal what is otherwise hidden"
						+ "\n TYPE SPYGLASS + OBJECT YOU WANT TO USE IT ON TO USE");
			}

		} else if (userInput.contains("box")) {
			 textBox.append("\n The box is locked");
		} else {
			 textBox.append("\n I do not understand what you want to open");
		}

	}

	@Override
	public void close() {

	}

	@Override
	public void move() {

	}

	@Override
	public void use() {

	}

	@Override
	public void turn() {

	}

	@Override
	public void take() {
		if (userInput.contains("box")) {
			 textBox.append("\n The box is bolted to its stand");
		}

	}

	@Override
	public void inspect() {
		if (userInput.contains("box")) {
			 textBox.append("\n This small metal box has a single lock on the front");
		} else {
			 textBox.append("\n I do not understand what you are inspecting");
		}

	}

	@Override
	public void investigate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void attack() {

	}

	@Override
	public void climb() {

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

	}

	@Override
	public void jump() {

	}

	@Override
	public void search() {

	}

	@Override
	public void look() {

	}

	@Override
	public void check() {
		if (userInput.contains("box")) {
			 textBox.append("\n This small metal box has a single lock on the front");
		} else {
			 textBox.append("\n I do not understand what you are inspecting");
		}
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
		if (userInput.contains("box")) {
			 textBox.append("\n The box does not break");
		} else {
			 textBox.append("\n I do not understand what you want to break");
		}

	}

	@Override
	public void smash() {
		if (userInput.contains("box")) {
			 textBox.append("\n The box does not break");
		} else {
			 textBox.append("\n I do not understand what you want to break");
		}

	}

	@Override
	public void north() {

	}

	@Override
	public void east() {
		if (playerLocation.equals("center")) {
			playerLocation = "eastDoor";
			 textBox.append("");
			 textBox.append("\n You stand before a wooden door");

		} else if (playerLocation.equals("westDoor")) {
			playerLocation = "center";
			 textBox.append("\n You are in front of the large door in the center");
			if (inventory.contains("westDoorPyramid")) {
				westDoorComplete = true;
				doorCheck();
			}
		} else {
			 textBox.append("\n You are as east as you can go");
		}

	}

	@Override
	public void south() {

	}

	@Override
	public void west() {
		if (playerLocation.equals("center")) {
			playerLocation = "westDoor";
			 textBox.append("\n You stand in front of an unassuming door");

		} else if (playerLocation.equals("eastDoor")) {
			playerLocation = "center";
			 textBox.append("\n You are in front of the large door in the center");
			if (inventory.contains("eastDoorPyramid")) {
				eastDoorComplete = true;
				doorCheck();
			}
		} else {
			 textBox.append("\n You are as west as you can go");
		}
	}

	@Override
	public void yes() {

	}

	@Override
	public void no() {

	}

	@Override
	public void Continue() { // MOVES TO NEXT ROOM

		getInventory();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub

	}

	@Override
	public void repeat() {
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
	public void spyglass() {

	}

	@Override
	public void inventory() {
		// Displays inventory
		if (!inventory.isEmpty()) {
			 textBox.append("\n" + inventory);
		} else {
			 textBox.append("\n Inventory is empty");
		}
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
	public void save(StateTracker z) {
		JSONObject greatDoor = new JSONObject();
		greatDoor.put("activeLevel", "com.briansandpuzzlegame.GreatDoor");

		JSONArray playerInv = new JSONArray();

		for (int i = 0; i < inventory.size(); i++) {
			playerInv.put(inventory.get(i));
		}

		greatDoor.put("Inv", playerInv);

		try {
			z.save(greatDoor, z.createFile());
		} catch (IOException e) {
			e.printStackTrace();
		}

		 textBox.append("\n Game Saved");

	}

	@Override
	public void load(StateTracker z)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

	}

	@Override
	public void loadCall(JSONObject params) {
		JSONObject paramaters = params;
		JSONArray inv = paramaters.getJSONArray("Inv");
		inventory = new ArrayList<String>();

		for (int i = 0; i < inv.length(); i++) {
			inventory.add(inv.getString(i));
		}

		System.out.println(inventory);

		 textBox.append("\n GAME SAVE LOADED");
		 textBox.append("\n Active room: " + "Great door");

	}

	@Override
	public void setTextBox(JTextArea textBox) {
		this.textBox = textBox;
	}

}
