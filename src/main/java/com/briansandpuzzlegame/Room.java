package com.briansandpuzzlegame;

public class Room {
	CommandParser parser;

	public Room(CommandParser parser) {
		this.parser = parser;
	}

	
	
	
	public void room() {
		
		String parserWords = parser.returnWords();

		parser.textBox.append("You stand in a dark room. You can see nothing in the darkness around you");

		System.out.println(parserWords);
		if (parser.verbList.contains(parserWords))
			
			parser.textBox.append("\nYou said the thing!");
		}

}
