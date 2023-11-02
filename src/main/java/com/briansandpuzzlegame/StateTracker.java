package com.briansandpuzzlegame;

/*
 * StateTracker handles the save/load functionality of the game.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.json.JSONObject;

public class StateTracker {
	CommandParser p;

	JSONObject gameTracker;
	Path filePath = Paths.get("state.json");
	String rawContent;
	IRoom activeRoom;

	/*
	 * The load method works in reverse of the save method. It will unpack the
	 * contents of the JSON file and write it all to a JSONObject. From there the
	 * method returns the JSONObject to the appropriate class determined by the
	 * activeLevel field written in the file.
	 */

	public void load() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		rawContent = new String(Files.readAllBytes(filePath));
		gameTracker = new JSONObject(rawContent);

		String activeLevel = (String) gameTracker.getString("activeLevel");

		// Reads activeLevel string stored in JSON and initializes IRoom instance of it
		@SuppressWarnings("deprecation")
		IRoom activeRoom = (IRoom) this.getClass().getClassLoader().loadClass(activeLevel).newInstance();

		p = new CommandParser(); // Initialize new command parser
		activeRoom.setParser(p); // Set the parser in active room

		p.loaded = true; // Tell CommandParser a file has been loaded
		p.run(); // Initialize GUI

		p.level.setText(activeLevel); // Set active level in Commandparser. Now jump to propertyChange

	}

	public void returnJSON() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		rawContent = new String(Files.readAllBytes(filePath));
		gameTracker = new JSONObject(rawContent);

		String activeLevel = (String) gameTracker.getString("activeLevel");

		@SuppressWarnings("deprecation")
		IRoom activeRoom = (IRoom) this.getClass().getClassLoader().loadClass(activeLevel).newInstance();
		
		activeRoom.loadCall(gameTracker); // Passes the JSON into activeLevel

	}
	/*
	 * Before this method is called the current active class takes all required
	 * fields and packs them into a single JSONObject. That JSONObject is then
	 * passed into this method, which then writes that JSONObject to the file.
	 */

	void save(JSONObject room) throws IOException {
		gameTracker = room;

		Files.newBufferedWriter(filePath, StandardOpenOption.TRUNCATE_EXISTING);
		rawContent = gameTracker.toString(gameTracker.length());
		Files.writeString(filePath, rawContent, StandardOpenOption.CREATE);

	}
}
