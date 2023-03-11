package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GreatDoor implements IRoom {
	CommandParser p;
	StateTracker a = new StateTracker(this);

	String userInput;
	String playerLocation = "center";
	List<String> inventory = new ArrayList<String>();

	public GreatDoor(CommandParser p) {
		this.p = p;

		setInventory(inventory);

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

			playerLocation = "puzzleBox";
			p.activeLevel = "East door puzzle";

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
	public void inventory() {
		// Displays inventory
		if (!inventory.isEmpty()) {
			p.textBox.append("\n" + inventory);
		} else {
			p.textBox.append("\n Inventory is empty");
		}
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
			p.textBox.append("\n You stand in front of an unassuming door"
					+ "\n Above the door there is a sign that reads: " + " LOCKED DOOR");

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
	public List<String> getInventory() {
		return inventory;
	}

	@Override
	public void setInventory(List<String> inventory) {

		this.inventory = inventory;

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
	public void save() throws IOException {

		p.textBox.append("\n Game Saved");
		a.inventory = inventory;
		a.currentRoom = p.activeLevel;

		a.save();
	}

	@Override
	public void load() throws IOException {

		a.load();
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub

	}

	@Override
	public void repeat() {
		// TODO Auto-generated method stub
		
	}

}
