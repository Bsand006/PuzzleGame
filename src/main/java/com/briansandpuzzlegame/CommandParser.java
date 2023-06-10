package com.briansandpuzzlegame;

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

public class CommandParser implements KeyListener, PropertyChangeListener {
	StateTracker z;

	Level1 r;
	GreatDoor a;
	EastDoorPuzzle b;
	WestDoorPuzzle c;

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

		r = new Level1(this);
		levels = new HashMap<>();
		levels.put("com.briansandpuzzlegame.Level1", r);

		// Generates game GUI

		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = size.width;
		int height = size.height;

		f = new JFrame();
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(width, height);
		f.setTitle("Zorp");
		f.getContentPane().setBackground(Color.darkGray);

		level = new JLabel();
		level.setText(activeLevel);
		level.addPropertyChangeListener(this);

		// Text font
		font = new Font("Monospaced", Font.BOLD, 17);

		// Text display box
		textBox = new JTextArea("Game started");
		textBox.setBounds(5, 5, width, height - 370);
		textBox.setFont(font);
		textBox.setForeground(Color.WHITE);
		textBox.setBackground(Color.BLACK);
		textBox.setEnabled(false);

		if (activeLevel.equals("com.briansandpuzzlegame.Level1")) {
			textBox.append("\n You stand in a pitch black room");
		}

		// User input box
		inputBox = new JTextField();

		inputBox.setBounds(5, height - 350, width, 50);

		// Scroller
		scroller = new JScrollPane(textBox);
		scroller.setBounds(5, 3, width, height - 370);

		f.add(scroller);
		f.add(inputBox);

		inputBox.addKeyListener(this); // Adds KeyListener

		verbs();
		adverbs();

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (evt.getOldValue() != evt.getNewValue()) {
			if (evt.getNewValue().equals("Great door")) {
				a = new GreatDoor(this);
				levels.put("Great door", a);
				a.firstTimeRun();
			} else if (evt.getNewValue().equals("East door puzzle")) {
				b = new EastDoorPuzzle(this);
				levels.put("East door puzzle", b);
				b.firstTimeRun();
			} else if (evt.getNewValue().equals("West door puzzle")) {
				c = new WestDoorPuzzle(this);
				levels.put("West door puzzle", c);
				c.firstTimeRun();
			}
		}
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
