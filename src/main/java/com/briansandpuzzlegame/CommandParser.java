package com.briansandpuzzlegame;

/*
 * CommandParser is the brain of the entire game. Here is where the game GUI is generated and where the 
 * players input is parsed and then passed to the proper room class.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.json.JSONObject;

public class CommandParser implements KeyListener, PropertyChangeListener {
	StateTracker z;

	TitleScreen t;

	IRoom room;

	Level1 r;
	GreatDoor a;
	EastDoorPuzzle b;
	WestDoorPuzzle c;
	SpookyStairs d;
	WaterRoom e;

	// Current room hashmap
	HashMap<String, IRoom> levels;

	// Parser wordlists
	ArrayList<String> verbList;
	ArrayList<String> adverbList;
	ArrayList<String> inv;

	// GUI fields
	JFrame f;
	JTextArea textBox;
	JTextField inputBox;
	JLabel level;
	JScrollPane scroller;
	Font font;

	public String words; // User input string

	/*
	 * This constructor creates the GUI interface and the Hashmap to track the
	 * active room
	 */

	void run() {

		// Hashmap to track active room
		levels = new HashMap<>();

		// Generates game GUI

		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = size.width;
		int height = size.height;

		f = new JFrame();
		f.setLayout(null);
		f.setSize(width, height);
		// f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setUndecorated(true);
		f.setTitle("Zorp");
		f.getContentPane().setBackground(Color.darkGray);
		f.setVisible(true);

		// Text font
		font = new Font("Monospaced", Font.BOLD, 17);

		// Text display box
		textBox = new JTextArea("Game started");
		textBox.setBounds(5, 5, width, height - 370);
		textBox.setFont(font);
		textBox.setForeground(Color.WHITE);
		textBox.setBackground(Color.BLACK);
		textBox.setEnabled(false);

		// User input box
		inputBox = new JTextField();
		inputBox.setBounds(5, height - 350, width, 50);

		// Scroller
		scroller = new JScrollPane(textBox);
		scroller.setBounds(5, 3, width, height - 370);

		f.add(scroller);
		f.add(inputBox);

		inputBox.addKeyListener(this); // Adds KeyListener to the user input box

		/*
		 * The parser uses a hidden JLabel that contains the text string of the current
		 * active class the player is in. There is then a hashmap that contains each
		 * class string and an object of that class. The parser uses a property listener
		 * on the JLabel to detect when the text changes to the next class, which
		 * matches with the hashmap.
		 */

		level = new JLabel();
		level.addPropertyChangeListener(this);

		r = new Level1(this);
		levels.put("com.briansandpuzzlegame.Level1", r);

		a = new GreatDoor(this);
		levels.put("com.briansandpuzzlegame.GreatDoor", a);

		b = new EastDoorPuzzle(this);
		levels.put("com.briansandpuzzlegame.EastDoorPuzzle", b);

		c = new WestDoorPuzzle(this);
		levels.put("com.briansandpuzzlegame.WestDoorPuzzle", c);

		d = new SpookyStairs(this);
		levels.put("com.briansandpuzzlegame.SpookyStairs", d);

		t = new TitleScreen(this);
		levels.put("com.briansandpuzzlegame.TitleScreen", t);
		level.setText("com.briansandpuzzlegame.TitleScreen");
		t.firstTimeRun();

		e = new WaterRoom(this);
		levels.put("com.briansandpuzzlegame.WaterRoom", e);

		// Parser accepted wordlists
		verbs();
		adverbs();

	}

	/*
	 * This propertyChange event method detects when the value of the hidden JLabel
	 * changes and initializes the class in the hashmap that corresponds with the
	 * new value of the JLabel.
	 */

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (evt.getOldValue() != evt.getNewValue()) {
			if (evt.getNewValue().equals("com.briansandpuzzlegame.Level1")) {

				r.firstTimeRun();

			} else if (evt.getNewValue().equals("com.briansandpuzzlegame.GreatDoor")) {

				IRoom old = room;
				inv = old.getInventory();
				a.firstTimeRun();
				a.setInventory(inv);
				old.close();

			} else if (evt.getNewValue().equals("com.briansandpuzzlegame.EastDoorPuzzle")) {

				IRoom old = room;
				inv = old.getInventory();
				b.firstTimeRun();
				b.setInventory(inv);
				old.close();

			} else if (evt.getNewValue().equals("com.briansandpuzzlegame.WestDoorPuzzle")) {

				IRoom old = room;
				inv = old.getInventory();
				c.firstTimeRun();
				c.setInventory(inv);
				old.close();

			} else if (evt.getNewValue().equals("com.briansandpuzzlegame.SpookyStairs")) {

				IRoom old = room;
				inv = old.getInventory();
				d.firstTimeRun();
				a.setInventory(inv);
				old.close();

			} else if (evt.getNewValue().equals("com.briansandpuzzlegame.WaterRoom")) {

				IRoom old = room;
				inv = old.getInventory();
				e.firstTimeRun();
				e.setInventory(inv);
				old.close();

			}
		}
	}

	public void loadJSON(JSONObject file) {
		JSONObject game = file;
		String activeRoom = game.getString("activeLevel");

		level.setText(activeRoom);

		switch (activeRoom) {

		case "com.briansandpuzzlegame.Level1":
			r.loadCall(game);

		case "com.briansandpuzzlegame.GreatDoor":
			a.loadCall(game);

		case "com.briansandpuzzlegame.EastDoorPuzzle":
			b.loadCall(game);

		case "com.briansandpuzzlegame.WestDoorPuzzle":
			c.loadCall(game);

		case "com.briansandpuzzlegame.SpookyStairs":
			d.loadCall(game);

		}

	}

	/*
	 * This is the parser behind the game. Using the keyPressed method, it parses
	 * every input the player enters and if the input contains a verb accepted by
	 * the parser, it will pass the players input to the proper active class
	 * according to the hashmap.
	 */

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

						room = levels.get(level.getText());
						System.out.println(level.getText());

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
		verbList.add("investigate");
		verbList.add("look");
		verbList.add("check");
		verbList.add("touch");
		verbList.add("throw");
		verbList.add("watch");
		verbList.add("wait");
		verbList.add("break");
		verbList.add("smash");
		verbList.add("walk");
		verbList.add("place");
		verbList.add("put");
		verbList.add("eat");
		verbList.add("defenestrate");
		verbList.add("oscillate");
		verbList.add("remove");

	}

	// Parser adverbs
	public void adverbs() {

		adverbList = new ArrayList<String>();

		adverbList.add("repeat");
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

	// Main driver method
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
