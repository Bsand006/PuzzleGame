package com.briansandpuzzlegame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

public class TitleScreen implements IRoom {
	CommandParser p;
	StateTracker z;

	File json = new File("state.json");
	boolean loadedfile;

	public TitleScreen(CommandParser p) {
		this.p = p;
	}

	@Override
	public void verbInterpreter() throws IOException {

		String userInput = p.inputPasser();

		if (userInput.equalsIgnoreCase("Yes"))
			yes();

		if (userInput.equalsIgnoreCase("No"))
			no();

	}

	@Override
	public void firstTimeRun() {

		p.textBox.append("\n Welcome to Zorp!");

		if (json.length() != 0) {
			p.textBox.append("\n You have a game file saved, would you like to load it?");
			loadedfile = true;
		} else {
			p.textBox.append("\n Would you like to start a new game?");
			loadedfile = false;
		}
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
		if (loadedfile == true) {
			p.textBox.append("\n LOADING FILE.....");
			z = new StateTracker();
			try {
				z.load();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}

		} else {
			p.textBox.append("\n Starting new game file...");
			p.level.setText("com.briansandpuzzlegame.Level1");
		}

	}

	@Override
	public void no() {
		if (loadedfile == true) {
			p.textBox.append("\n Starting new game file...");
			p.level.setText("com.briansandpuzzlegame.Level1");
		
		} else {
			p.textBox.append("\n EXITING...");
			try {
				wait(3);
				exit();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

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

		return null;
	}

	@Override
	public void setInventory(ArrayList<String> inventory) {

	}

}