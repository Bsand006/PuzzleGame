package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

public class WaterRoom implements IRoom {
	CommandParser p;
	StateTracker z;

	String userInput;
	ArrayList<String> inventory;

	int turns = 8;

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

		p.textBox.append("\n You find yourself at one end of this long room"
				+ "\n The walls are lined with human-like head statues, placed equally apart"
				+ " \n In the center of the room is a stone pedastel with the top slanted");

	}

	@Override
	public void setParser(CommandParser p) {

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

	}

	@Override
	public void close() {

	}

	@Override
	public void move() {

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

	}

	@Override
	public void investigate() {

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
		p.textBox.append("\n You find yourself at one end of this long room"
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

}
