package com.briansandpuzzlegame;

import java.util.ArrayList;
import java.util.List;

public class Room implements IRoom {
	CommandParser p;

	String userInput;
	List<Boolean> playerState = new ArrayList<Boolean>();
	

	boolean movedFoward = false;
	boolean inspectedObject = false;
	

	public Room(CommandParser p) {
		this.p = p;
	}

	public void verbInterpreter() {

		userInput = p.inputPasser();
		System.out.println(userInput);

		if (userInput.contains("look"))
			look();

		if (userInput.contains("move"))
			move();

		if (userInput.contains("search"))
			search();

		if (userInput.contains("inspect"))
			inspect();
		
		if (userInput.contains("push"))
			push();

	}

	public void enter() {
	}

	public void go() {
	}

	public void push() {
		
		if (userInput.contains("button") && inspectedObject == true) {
			p.textBox.append("\n You push the button. The room floods with bright light"
					+ "\n You stand in a large square room made of concrete"
					+ "\n There is a metal door to the north. There is a table to the east");
		
		} else {
			p.textBox.append("\n I do not understand what you are trying to push");
		}
		
	}
	
	public void open() {
	}

	public void close() {
	}

	public void move() {
		if (userInput.contains("foward")) {
			p.textBox.append("\n You move into the room and bump into some object");
			movedFoward = true;
		} else {
			p.textBox.append("\n I do not understand where you are trying to move to");
		}
	}

	public void use() {
	}

	public void turn() {
	}

	public void take() {
	}

	public void inspect() {
		if (userInput.contains("object")) {

			if (movedFoward == true) {
				p.textBox.append(
						"\n You run your hand along its metallic surface and you feel a button");
				inspectedObject = true;
			}
		} else {
			p.textBox.append("\n I do not understand what you are inspecting");
		}
	}

	public void attack() {
	}

	public void climb() {
	}

	public void descend() {
	}

	public void run() {
	}

	public void hide() {
	}

	public void crawl() {
	}

	public void jump() {
	}

	public void search() {
		if (userInput.contains("lightswitch")) {
			p.textBox.append("\n You search the walls for a lightswitch and do not find one");
		} else {
			p.textBox.append("\n I do not understand what you are searching for");
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
	}

	public void north() {
	}

	public void east() {
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
