package com.briansandpuzzlegame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class StateTracker {
	CommandParser p;
	Level1 a;
	EastDoorPuzzle b;
	GreatDoor c;

	String currentRoom; // Current room the player is in
	List<String> inventory = new ArrayList<String>(); // Plater inventory

	// Level1

	List<String> playerState = new ArrayList<String>();

	// EastDoorPuzzle

	boolean[] locks = new boolean[4];
	boolean boxOpen = false;

	// JSON objects

	JSONObject gameTracker;
	JSONArray level1State;
	JSONArray eastDoorLocks;
	JSONArray playerInventory;
	Path filePath = Paths.get("/home/brain/Git/PuzzleGame/state.json");
	String rawContent;

	public StateTracker(CommandParser p) {
		this.p = p;
	}
	
	public StateTracker(Level1 a) {
		this.a = a;
	}

	public StateTracker(GreatDoor c) {
		this.c = c;
	}

	public StateTracker(EastDoorPuzzle b) {
		this.b = b;
	}

	void JSONSetup() { // Setup JSON file
	
		
		gameTracker = new JSONObject();
		gameTracker.put("Active Class", currentRoom);

		// If player is on the first level
		if (currentRoom.equals("First level")) {
			level1State = new JSONArray();

			level1State.put(1, playerState);

			gameTracker.put("level1State", level1State);
		}

		// If player has completed the east door puzzle
		if (boxOpen == true && !currentRoom.equals("East Door Puzzle")) {
			gameTracker.put("boxOpen?", boxOpen);

			// If the player is in east door puzzle
		} else if (boxOpen != true && currentRoom.equals("East Door Puzzle")) {

			eastDoorLocks = new JSONArray();

			for (int i = 0; i < locks.length; i++)
				eastDoorLocks.put(i, locks[i]);

			gameTracker.put("eastDoorBoxLocks", eastDoorLocks);
			gameTracker.put("boxOpen?", boxOpen);

		}

		// Player inventory
		playerInventory = new JSONArray();
		playerInventory.put(1, inventory);
		gameTracker.put("inventory", playerInventory);

	}

	void load() throws IOException { // Load functionality

		p.textBox.append("\n LOADING SAVE FILE...");
		rawContent = new String(Files.readAllBytes(filePath));

		if (!rawContent.isBlank()) {

			gameTracker = new JSONObject(rawContent);

			p.activeLevel = gameTracker.getString("Active Class");
			p.textBox.append("\n Player is currently in : " + p.activeLevel);

			boxOpen = gameTracker.getBoolean("boxOpen?");

			switch (p.activeLevel) {

			case ("First level"): // Level 1

				// Inventory

				playerInventory = new JSONArray();
				playerInventory.put(gameTracker.get("inventory"));
				inventory = new ArrayList<String>();
				inventory.add(playerInventory.toString());
				a.inventory = inventory;
				System.out.println(inventory);

				// Player state tracker

				level1State = new JSONArray();
				level1State.put(gameTracker.get("level1State"));
				playerState = new ArrayList<String>();
				playerState.add(level1State.toString());
				a.playerState = playerState;
				System.out.println(playerState);

			case ("Great door"):

				// Inventory

				playerInventory = new JSONArray();
				playerInventory.put(gameTracker.get("inventory"));
				inventory = new ArrayList<String>();
				inventory.add(playerInventory.toString());
				c.inventory = inventory;
				System.out.println(inventory);

			case ("East door puzzle"):

				// Inventory

				playerInventory = new JSONArray();
				playerInventory.put(gameTracker.get("inventory"));
				inventory = new ArrayList<String>();
				inventory.add(playerInventory.toString());
				b.inventory = inventory;
				System.out.println(inventory);

				// East puzzlebox locks

				eastDoorLocks = new JSONArray();
				eastDoorLocks.put(gameTracker.get("eastDoorBoxLocks"));
				locks = new boolean[eastDoorLocks.length()];

				for (int i = 0; i < locks.length; i++)
					locks[i] = eastDoorLocks.getBoolean(i);
			}

		} else {
			p.textBox.append("\n ERROR! No save file to load");
		}
	}

	void save() throws IOException { // Save functionality

		rawContent = gameTracker.toString(gameTracker.length());
		Files.writeString(filePath, rawContent, StandardOpenOption.CREATE);

	}
}
