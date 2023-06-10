package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class GreatDoor implements IRoom {
	CommandParser p;

	String userInput;
	String playerLocation = "center";
	List<String> inventory = new ArrayList<String>();
	boolean eastDoorComplete = false;
	boolean westDoorComplete = false;

	public GreatDoor() {

	}

	public GreatDoor(CommandParser p) {
		this.p = p;

	}

	@Override
	public void firstTimeRun() {
		System.out.println("fdsfasdafa");
		setInventory(inventory);
		System.out.println(inventory);

		p.textBox.setText("");
		p.textBox.append("You step into a large room");
		p.textBox.append("\n To the north is a large door 20ft tall");
		p.textBox.append("\n There are 5 pedastals in a row in front of the door");
		p.textBox.append("\n To the east there is a small wood door");
		p.textBox.append("\n To the west there is another door");
		p.textBox.append("\n A small metal box lies on a table in the room");

	}

	@Override
	public void verbInterpreter() {

		userInput = p.inputPasser();
		System.out.println(userInput);

		if (userInput.contains("east"))
			east();

		if (userInput.contains("west"))
			west();

		if (userInput.contains("north"))
			north();

		if (userInput.contains("south"))
			south();

		if (userInput.contains("open"))
			open();

		if (userInput.contains("inventory"))
			inventory();

		if (userInput.contains("inspect"))
			inspect();

		if (userInput.contains("investigate"))
			investigate();

		if (userInput.contains("search"))
			search();

	}

	@Override
	public void enter() {

	}

	@Override
	public void push() {

	}

	@Override
	public void go() {

	}

	@Override
	public void open() {

		if (userInput.contains("door") && playerLocation.equals("eastDoor")) {
			if (eastDoorComplete == false) {
				playerLocation = "puzzleBox";
				p.activeLevel = "East door puzzle";
				p.level.setText("East door puzzle");
			} else {
				p.textBox.append("\n There is nothing more to do in there");
			}

		} else if (userInput.contains("door") && playerLocation.equals("westDoor")) {
			if (westDoorComplete == false) {
				playerLocation = "West door";
				p.activeLevel = "West door puzzle";

			}

		} else {
			p.textBox.append("\n I do not understand what you want to open");
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

	}

	@Override
	public void inspect() {
		if (userInput.contains("box")) {
			p.textBox.append("\n This small metal box has a single lock on the front");
		} else {
			p.textBox.append("\n I do not understand what you are inspecting");
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

	}

	@Override
	public void touch() {
		System.out.println("touch");

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
	public void north() {

	}

	@Override
	public void east() {
		if (playerLocation.equals("center")) {
			playerLocation = "eastDoor";
			p.textBox.append("");
			p.textBox.append("\n You stand before a wooden door");

		} else if (playerLocation.equals("westDoor")) {
			playerLocation = "center";
			p.textBox.append("\n You are in front of the large door in the center");
		} else {
			p.textBox.append("\n You are as east as you can go");
		}

	}

	@Override
	public void south() {

	}

	@Override
	public void west() {
		if (playerLocation.equals("center")) {
			playerLocation = "westDoor";
			p.textBox.append("\n You stand in front of an unassuming door");

		} else if (playerLocation.equals("eastDoor")) {
			playerLocation = "center";
			p.textBox.append("\n You are in front of the large door in the center");
		} else {
			p.textBox.append("\n You are as west as you can go");
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
	public void inventory() {
		// Displays inventory
		if (!inventory.isEmpty()) {
			p.textBox.append("\n" + inventory);
		} else {
			p.textBox.append("\n Inventory is empty");
		}
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
		JSONObject greatDoor = new JSONObject();
		greatDoor.put("activeLevel", "com.briansandpuzzlegame.GreatDoor");

		JSONArray playerInv = new JSONArray();

		for (int i = 0; i < inventory.size(); i++) {
			playerInv.put(inventory.get(i));
		}
		
		greatDoor.put("Inv", playerInv);

		p.textBox.append("\n Game Saved");

	}

	@Override
	public void load(StateTracker z)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

		z.load();
	}

	@Override
	public void loadCall(JSONObject params) {
		JSONObject paramaters = params;

		JSONArray inv = paramaters.getJSONArray("Inv");
		inventory.clear();

		for (int i = 0; i < inv.length(); i++) {
			inventory.add(inv.getString(i));
		}

		p.textBox.append("\n GAME SAVE LOADED");
		p.textBox.append("\n Active room: " + "Great door");

	}

	@Override
	public void setParser(CommandParser p) {
		// TODO Auto-generated method stub

	}

}
