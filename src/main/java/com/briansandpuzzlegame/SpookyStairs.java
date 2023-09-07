package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class SpookyStairs implements IRoom {
	CommandParser p;
	StateTracker z;
	
	String userInput;
	List<String>inventory = new ArrayList<String>();
	

	public SpookyStairs() {
	}
	
	public SpookyStairs(CommandParser p) {
		this.p = p;
	}
	
	@Override
	public void verbInterpreter() throws IOException {
		 

	}

	@Override
	public void firstTimeRun() {
		 

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
	public List<String> getInventory() {
		 
		return null;
	}

	@Override
	public void setInventory(List<String> inventory) {
		 

	}

}
