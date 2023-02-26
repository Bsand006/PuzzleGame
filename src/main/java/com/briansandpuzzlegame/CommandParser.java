package com.briansandpuzzlegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.json.JSONArray;
import org.json.JSONObject;

public class CommandParser implements KeyListener {
	Level1 r;
	GreatDoor a;
	EastDoorPuzzle b;

	// Game tracker JSON
	JSONObject gameTracker;
	JSONArray eastDoorLocks;
	Path filePath = Paths.get("/home/brain/Git/PuzzleGame/state.json");
	String rawContent;

	// Current room hashmap
	HashMap<String, IRoom> levels;
	String activeLevel;

	// Parser wordlists
	ArrayList<String> verbList;
	ArrayList<String> adverbList;

	// GUI variables
	JFrame f;
	JTextArea textBox;
	JTextField inputBox;
	JScrollPane scroller;
	Font font;

	public String words; // User input string

	void run() {

		// Hashmap to track active room

		r = new Level1(this);
		a = new GreatDoor(this);
		b = new EastDoorPuzzle(this);

		levels = new HashMap<>();

		levels.put("First level", r);
		levels.put("Great door", a);
		levels.put("East door puzzle", b);
		activeLevel = "First level";

		// Generates game GUI

		f = new JFrame();
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(850, 600);
		f.setTitle("Zorp");
		f.getContentPane().setBackground(Color.BLACK);

		// Text font
		font = new Font("Monospaced", Font.BOLD, 17);

		// Text display box
		textBox = new JTextArea(" You stand in a pitch black room");
		textBox.setBounds(5, 5, 500, 200);
		textBox.setFont(font);
		textBox.setForeground(Color.WHITE);
		textBox.setBackground(Color.BLACK);
		textBox.setEnabled(false);

		// User input box
		inputBox = new JTextField();
		inputBox.setBounds(5, 454, 800, 50);

		// Scroller
		scroller = new JScrollPane(textBox);
		scroller.setBounds(3, 3, 800, 450);

		f.add(scroller);
		f.add(inputBox);

		inputBox.addKeyListener(this); // Adds KeyListener

		// Runs list methods
		verbs();
		adverbs();

	}

	void load() throws IOException {

		rawContent = new String(Files.readAllBytes(filePath));
		gameTracker = new JSONObject(rawContent);

		gameTracker.put("level1Done", false);
		gameTracker.put("eastDoorPuzzleDone", false);

		eastDoorLocks = new JSONArray();
		gameTracker.put("eastDoorLocks", eastDoorLocks);
		eastDoorLocks.put(1, false);
		eastDoorLocks.put(2, false);
		eastDoorLocks.put(3, false);
		eastDoorLocks.put(4, false);
		rawContent = gameTracker.toString(gameTracker.length());

	}

	void save() throws IOException {

		Files.writeString(filePath, "MEEP", StandardOpenOption.CREATE);

	}

	// Parser
	public void keyPressed(KeyEvent e) {

		if (e.getSource() == inputBox) {

			int keyCode = e.getKeyCode(); // Sets key pressed to integer value

			if (keyCode == KeyEvent.VK_ENTER) { // If enter key is pressed

				// Sets words to typed words and clears inputBox
				words = inputBox.getText();
				inputBox.setText("");

				String[] split = words.split(" "); // Splits typed words into a String array

				for (String a : split) {

					if (verbList.contains(a) || adverbList.contains(a)) {
						inputPasser();

						IRoom room = levels.get(activeLevel);
						try {
							room.verbInterpreter();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

						break;
					} else
						textBox.append("\n" + a + " is not a verb I recognize");
					break;
				}
			}
		}
	}

	// Passes typed words to other class if it contains a matching verb
	public String inputPasser() {

		return words;
	}

	// Parser verbs
	public void verbs() {

		verbList = new ArrayList<String>();

		verbList.add("enter");
		verbList.add("push");
		verbList.add("go");
		verbList.add("open");
		verbList.add("close");
		verbList.add("move");
		verbList.add("use");
		verbList.add("turn");
		verbList.add("take");
		verbList.add("inspect");
		verbList.add("attack");
		verbList.add("flee");
		verbList.add("climb");
		verbList.add("descend");
		verbList.add("run");
		verbList.add("hide");
		verbList.add("crawl");
		verbList.add("jump");
		verbList.add("search");
		verbList.add("look");
		verbList.add("check");
		verbList.add("touch");
		verbList.add("throw");
		verbList.add("watch");
		verbList.add("wait");
		verbList.add("break");
		verbList.add("smash");

	}

	// Parser adverbs
	public void adverbs() {

		adverbList = new ArrayList<String>();

		adverbList.add("load");
		adverbList.add("save");
		adverbList.add("inventory");
		adverbList.add("continue");
		adverbList.add("leave");
		adverbList.add("exit");
		adverbList.add("north");
		adverbList.add("northeast");
		adverbList.add("east");
		adverbList.add("southeast");
		adverbList.add("south");
		adverbList.add("southwest");
		adverbList.add("west");
		adverbList.add("northwest");
		adverbList.add("yes");
		adverbList.add("no");

	}

	// Launches Program
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CommandParser().run();

			}
		});
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
}
