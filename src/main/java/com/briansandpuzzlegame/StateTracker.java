package com.briansandpuzzlegame;

import java.util.ArrayList;
import java.util.List;

public class StateTracker {
	CommandParser p;
	Level1 a;
	EastDoorPuzzle b;
	GreatDoor c;

	String currentRoom;

	List<String> inventory = new ArrayList<String>();
	List<String> playerState = new ArrayList<String>();

	boolean[] locks = new boolean[4];
	boolean boxOpen = false;

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

}
