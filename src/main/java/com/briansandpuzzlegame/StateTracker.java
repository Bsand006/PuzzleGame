package com.briansandpuzzlegame;

import java.io.File;

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
	String rawContent;
	IRoom activeRoom;

	public Path createFile() {

		try {
			File file = new File("state.json");
			if (file.createNewFile()) {
				Path pathToFile = Paths.get("state.json");
				return pathToFile;
			} else {
				System.out.println("FILE ALREADY EXISTS");
				Path path = Paths.get("state.json");

				return path;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * The load method works in reverse of the save method. It will unpack the
	 * contents of the JSON file and write it all to a JSONObject. From there the
	 * method returns the JSONObject to the appropriate class determined by the
	 * activeLevel field written in the file.
	 */

	public void load(Path file)
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Path path = file;

		rawContent = new String(Files.readAllBytes(path));
		gameTracker = new JSONObject(rawContent);
		p = new CommandParser();
		p.loaded = true;
		p.run();

		p.loadJSON(gameTracker);

	}

	/*
	 * Before this method is called the current active class takes all required
	 * fields and packs them into a single JSONObject. That JSONObject is then
	 * passed into this method, which then writes that JSONObject to the file.
	 */

	void save(JSONObject room, Path file) throws IOException {
		gameTracker = room;
		Path path = file;

		Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING);
		rawContent = gameTracker.toString(gameTracker.length());
		Files.writeString(path, rawContent, StandardOpenOption.CREATE);

	}
}
