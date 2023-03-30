package com.briansandpuzzlegame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import org.json.JSONArray;
import org.json.JSONObject;

public class StateTracker {

	String currentRoom; // Current room the player is in

	List<String> inventory = new ArrayList<String>(); // Player inventory

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

	JTextArea textBox;

	public StateTracker(JTextArea textBox) {
		this.textBox = textBox;
	}

	void load(String activeLevel) throws IOException { // Load functionality

		textBox.append("\n LOADING SAVE FILE...");
		rawContent = new String(Files.readAllBytes(filePath));

		if (!rawContent.isBlank()) {

			gameTracker = new JSONObject(rawContent);
			boxOpen = gameTracker.getBoolean("boxOpen?");

			switch (activeLevel) {

			case ("First level"): // Level 1

				// Inventory

				playerInventory = new JSONArray();
				playerInventory.put(gameTracker.get("inventory"));
				inventory = new ArrayList<String>();
				inventory.add(playerInventory.toString());
				System.out.println(inventory);

				// Player state tracker

				level1State = new JSONArray();
				level1State.put(gameTracker.get("level1State"));
				playerState = new ArrayList<String>();
				playerState.add(level1State.toString());
				System.out.println(playerState);

			case ("Great door"):

				// Inventory

				playerInventory = new JSONArray();
				playerInventory.put(gameTracker.get("inventory"));
				inventory = new ArrayList<String>();
				inventory.add(playerInventory.toString());
				System.out.println(inventory);

			case ("East door puzzle"):

				// Inventory

				playerInventory = new JSONArray();
				playerInventory.put(gameTracker.get("inventory"));
				inventory = new ArrayList<String>();
				inventory.add(playerInventory.toString());
				System.out.println(inventory);

				// East puzzlebox locks

				eastDoorLocks = new JSONArray();
				eastDoorLocks.put(gameTracker.get("eastDoorBoxLocks"));
				locks = new boolean[eastDoorLocks.length()];

				for (int i = 0; i < locks.length; i++)
					locks[i] = eastDoorLocks.getBoolean(i);
			}

		} else {
			throw new IOException("Error reading file!");
		}
	}

	void save() throws IOException { // Save functionality

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

		rawContent = gameTracker.toString(gameTracker.length());
		Files.writeString(filePath, rawContent, StandardOpenOption.CREATE);

	}

	public String getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(String currentRoom) {
		this.currentRoom = currentRoom;
	}

	public List<String> getInventory() {
		return inventory;
	}

	public void setInventory(List<String> inventory) {
		this.inventory = inventory;
	}

	public List<String> getPlayerState() {
		return playerState;
	}

	public void setPlayerState(List<String> playerState) {
		this.playerState = playerState;
	}

	public boolean[] getLocks() {
		return locks;
	} 	

	public void setLocks(boolean[] locks) {
		this.locks = locks;
	}

	public boolean isBoxOpen() {
		return boxOpen;
	}

	public void setBoxOpen(boolean boxOpen) {
		this.boxOpen = boxOpen;
	}

}
