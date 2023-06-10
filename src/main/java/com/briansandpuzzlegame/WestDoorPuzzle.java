package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class WestDoorPuzzle implements IRoom {
	CommandParser p;

	String userInput;
	List<String> inventory = new ArrayList<String>();
	int grid[][] = new int[4][4];
	int skullsLeft = 9;
	boolean solved = false;

	public WestDoorPuzzle() {

	}
	
	@Override
	public void setParser(CommandParser p) {
		// TODO Auto-generated method stub
		
	}


	public WestDoorPuzzle(CommandParser p) {
		this.p = p;
		firstTimeRun();
	}

	public void firstTimeRun() {
		setInventory(inventory);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < i; j++) {
				grid[i][j] = 0;
			}
		}
		
		p.textBox.append("\n ");
		p.textBox.append("\n Nine skulls rest near a four-foot square set of tiles in the floor"
				+ "\n The tiles are arranged in a four by four square"
				+ "\n Stone panels on the top and right side of the square label the rows and columns"
				+ "\n The columns are labeled from left to right : III, I, II, III"
				+ "\n The rows are labeled from top to bottom : III, II, III, I");

	}

	@Override
	public void verbInterpreter() throws IOException {
		userInput = p.inputPasser();

		if (userInput.contains("inspect"))
			inspect();

		if (userInput.contains("search"))
			search();

		if (userInput.contains("investigate"))
			investigate();

		if (userInput.contains("check"))
			check();

		if (userInput.contains("take"))
			take();

		if (userInput.contains("put"))
			put();

		if (userInput.contains("place"))
			place();

		if (userInput.contains("inventory"))
			inventory();

	}

	public void winCheck() {

		if (grid[0][0] + grid[0][1] + grid[0][2] + grid[0][3] == 3)
			if (grid[1][0] + grid[1][1] + grid[1][2] + grid[1][3] == 1)
				if (grid[2][0] + grid[2][1] + grid[2][2] + grid[2][3] == 2)
					if (grid[3][0] + grid[3][1] + grid[3][2] + grid[3][3] == 3)
						if (grid[3][0] + grid[2][0] + grid[1][0] + grid[0][0] == 3)
							if (grid[3][1] + grid[2][1] + grid[1][1] + grid[0][1] == 2)
								if (grid[3][2] + grid[2][2] + grid[1][2] + grid[0][2] == 3)
									if (grid[3][3] + grid[2][3] + grid[1][3] + grid[0][3] == 1) {
										solved = true;
										System.out.println("AHHHHHHHHHHHHH");
									}

	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void push() {
		// TODO Auto-generated method stub

	}

	@Override
	public void go() {
		// TODO Auto-generated method stub

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
	public void walk() {
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

		if (userInput.contains("skulls")) {
			p.textBox.append("\n You take the nine skulls");

			inventory.add(inventory.size(), "skulls : 9");
		}
	}

	@Override
	public void inspect() {

		if (userInput.contains("skulls")) {
			p.textBox.append("\n These nine skulls have been here for a long time");

		} else if (userInput.contains("tiles") || userInput.contains("squares")) {
			p.textBox.append("\n The 4x4 set of tiles have indents in them");

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
		// TODO Auto-generated method stub

	}

	@Override
	public void smash() {
		// TODO Auto-generated method stub

	}

	@Override
	public void put() {
		// TODO Auto-generated method stub

	}

	@Override
	public void place() {

		if (solved == false) {
			String[] split = userInput.split(" ");

			try {
				String[] nums = split[1].split(",");
				int x = Integer.parseInt(nums[0]);
				int y = Integer.parseInt(nums[1]);

				if (x < 4 && y < 4) {
					if (grid[x][y] == 0) {
						grid[x][y] = 1;
						p.textBox.append("\n Placing skull on tile " + x + "," + y);
						winCheck();
						skullsLeft--;
						// inventory.set(inventory.size(), "skulls : " + skullsLeft);
					} else
						p.textBox.append("\n Square already occupied");
				} else
					p.textBox.append("\n Invalid coordinates");

			} catch (Exception e) {
				p.textBox.append("\n Caught exception " + e.toString() + "\n Please include comma-separated coordinates"
						+ "\n Example: '0,0'");

			}

		} else
			p.textBox.append("\n Puzzle is solved");
	}

	@Override
	public void remove() {
		if (userInput.contains("skull")) {

		}
	}

	@Override
	public void inventory() {

		if (!inventory.isEmpty()) {
			p.textBox.append("\n" + inventory);
		} else {
			p.textBox.append("\n Inventory is empty");
		}
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
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Continue() {
		// TODO Auto-generated method stub

	}

	@Override
	public void repeat() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(StateTracker z) {
		// TODO Auto-generated method stub

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
	public void load(StateTracker z)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadCall(JSONObject params) {
		JSONObject paramaters = params;
		inventory = (List<String>) paramaters.get("Inv");

	}

	
}
