package com.briansandpuzzlegame;

public class EastDoorPuzzle implements IRoom {
	CommandParser p;
	
	String userInput;
	boolean[] locks = new boolean[4];
	
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Throw() {
		// TODO Auto-generated method stub
		
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

}
