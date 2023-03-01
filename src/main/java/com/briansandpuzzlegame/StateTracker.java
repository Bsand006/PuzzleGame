package com.briansandpuzzlegame;

import java.util.List;

public class StateTracker {
	CommandParser p;
	
	Level1 a;

	List<String> inventory;
	
	public StateTracker(CommandParser p) {

		this.p = p;
	}

	public void getInventory(List<String> inventory) {
		
		this.inventory = inventory;
		
		System.out.println(inventory);
		
	}
	
}
