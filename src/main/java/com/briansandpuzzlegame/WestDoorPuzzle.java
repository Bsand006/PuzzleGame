package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import org.json.JSONArray;
import org.json.JSONObject;

public class WestDoorPuzzle implements IRoom {
	CommandParser p;
	JTextArea textBox;

	StateTracker z;
	String userInput;
	ArrayList<String> inventory = new ArrayList<String>();
	int grid[][] = new int[4][4];
	int skullsLeft = 9;
	boolean solved = false;
	String skulls;

	@Override
	public void setParser(CommandParser p) {

	}

	public WestDoorPuzzle(CommandParser p) {
		this.p = p;
	}

	public void firstTimeRun() {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < i; j++) {
				grid[i][j] = 0;
			}
		}

		 textBox.append("\n ");
		 textBox.append("\n Nine skulls rest near a four-foot square set of tiles in the floor"
				+ "\n The tiles are arranged in a four by four square"
				+ "\n Stone panels on the top and right side of the square label the rows and columns"
				+ "\n The columns are labeled from left to right : III, I, II, III"
				+ "\n The rows are labeled from top to bottom : III, II, III, I");

	}

	@Override
	public void verbInterpreter() throws IOException {
		userInput =  p.inputPasser();

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
										 textBox.append(
												"\n The tiles light up as a slab of stone in the back slides to the side"
														+ "\n Behind the stone slab is a small intricate pyramid and a key");
									}
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

		switch (userInput) {

		case "skulls":
			 textBox.append("\n You take the nine skulls");
			skulls = "Skulls : " + skullsLeft;

			inventory.add(skulls);

		case "pyramid":
			 textBox.append("\n You take the pyramid");
			inventory.add("westRoomPyramid");

		case "key":
			 textBox.append("\n You take the key");
			inventory.add("westRoomKey");
		}

	}

	@Override
	public void inspect() {

		if (userInput.contains("skulls")) {
			 textBox.append("\n These nine skulls have been here for a long time");

		} else if (userInput.contains("tiles") || userInput.contains("squares")) {
			 textBox.append("\n The 4x4 set of tiles have indents in them");

		} else {
			 textBox.append("\n I do not understand what you are inspecting");
		}

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

		if (solved == false && inventory.contains(skulls) && skullsLeft > 0) {
			String[] split = userInput.split(" ");

			try {
				String[] nums = split[1].split(",");
				int x = Integer.parseInt(nums[0]);
				int y = Integer.parseInt(nums[1]);

				if (x < 4 && y < 4) {
					if (grid[x][y] == 0) {
						grid[x][y] = 1;
						 textBox.append("\n Placing skull on tile " + x + "," + y);
						winCheck();
						skullsLeft--;
						skulls = "Skulls : " + skullsLeft;

					} else
						 textBox.append("\n Square already occupied");
				} else
					 textBox.append("\n Invalid coordinates");

			} catch (Exception e) {
				 textBox.append("\n Caught exception " + e.toString() + "\n Please include comma-separated coordinates"
						+ "\n Example: '0,0'");
			}

		} else
			 textBox.append("\n Puzzle is solved");
	}

	@Override
	public void remove() {
		if (solved == false && inventory.contains(skulls) && skullsLeft > 0) {
			String[] split = userInput.split(" ");

			try {
				String[] nums = split[1].split(",");
				int x = Integer.parseInt(nums[0]);
				int y = Integer.parseInt(nums[1]);

				if (x < 4 && y < 4) {
					if (grid[x][y] == 1) {
						grid[x][y] = 0;
						 textBox.append("\n Removing skull on tile " + x + "," + y);
						winCheck();
						skullsLeft++;
						skulls = "Skulls : " + skullsLeft;

					} else
						 textBox.append("\n ");
				} else
					 textBox.append("\n Invalid coordinates");

			} catch (Exception e) {
				 textBox.append("\n Caught exception " + e.toString() + "\n Please include comma-separated coordinates"
						+ "\n Example: '0,0'");
			}

		} else
			 textBox.append("\n Puzzle is solved");
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
	public void Continue() {

	}

	@Override
	public void spyglass() {

	}

	@Override
	public void repeat() {

	}

	@Override
	public void save(StateTracker z) {

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
	public void load(StateTracker z)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadCall(JSONObject params) {
		JSONObject paramaters = params;
		JSONArray inv = paramaters.getJSONArray("Inv");
		inventory = new ArrayList<String>();

		for (int i = 0; i < inv.length(); i++) {
			inventory.add(inv.getString(i));
		}

	}

	@Override
	public void setTextBox(JTextArea textBox) {
		this.textBox = textBox;
	}

}
