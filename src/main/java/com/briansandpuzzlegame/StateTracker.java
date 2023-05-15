package com.briansandpuzzlegame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.json.JSONObject;

public class StateTracker {

	JSONObject gameTracker;
	Path filePath = Paths.get("state.json");
	String rawContent;

	void load() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		rawContent = new String(Files.readAllBytes(filePath));
		gameTracker = new JSONObject(rawContent);

		String activeLevel = (String) gameTracker.getString("activeLevel");

		IRoom activeRoom = (IRoom) this.getClass().getClassLoader().loadClass(activeLevel).newInstance();

		activeRoom.loadCall(gameTracker);

	}

	void save(JSONObject room) throws IOException { // Save functionality
		gameTracker = room;

		Files.newBufferedWriter(filePath, StandardOpenOption.TRUNCATE_EXISTING);
		rawContent = gameTracker.toString(gameTracker.length());
		Files.writeString(filePath, rawContent, StandardOpenOption.CREATE);

	}
}
