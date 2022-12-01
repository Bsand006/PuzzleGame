package com.briansandpuzzlegame;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CommandParser implements KeyListener {

	// Parser wordlists
	ArrayList<String> verbList;
	ArrayList<String> adverbList;

	// GUI variables
	JFrame f;
	JTextArea textBox;
	JTextField inputBox;
	JScrollPane scroller;
	Font font;

	// User input string
	String words;
	public String wordPasser;

	// Game GUI
	void run() {

		// JFrame
		f = new JFrame();
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(850, 600);
		f.setTitle("-");
		f.getContentPane().setBackground(Color.BLACK);

		// Text font
		font = new Font("Monospaced", Font.BOLD, 17);

		// Text box
		textBox = new JTextArea();
		textBox.setBounds(5, 5, 500, 200);
		textBox.setFont(font);
		textBox.setForeground(Color.WHITE);
		textBox.setBackground(Color.BLACK);
		textBox.setEnabled(false);

		inputBox = new JTextField();
		inputBox.setBounds(5, 454, 800, 50);

		// Scroller
		scroller = new JScrollPane(textBox);
		scroller.setBounds(3, 3, 800, 450);

		f.add(scroller);
		f.add(inputBox);

		inputBox.addKeyListener(this);

		verbs();
		adverbs();

		Room r = new Room(this);
		r.room();

	}

	// Parser verbs
	public void verbs() {

		verbList = new ArrayList<String>();

		verbList.add("enter");
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
		verbList.add("inventory");

	}

	// Parser adverbs
	public void adverbs() {

		adverbList = new ArrayList<String>();

		adverbList.add("north");
		adverbList.add("northeast");
		adverbList.add("east");
		adverbList.add("southeast");
		adverbList.add("south");
		adverbList.add("southwest");
		adverbList.add("west");
		adverbList.add("northwest");

	}

	// Parser
	public void keyPressed(KeyEvent e) {

		if (e.getSource() == inputBox) {

			int keyCode = e.getKeyCode();

			if (keyCode == KeyEvent.VK_ENTER) {

				words = inputBox.getText();
				inputBox.setText("");

				String[] split = words.split(" ");
				System.out.println(split);

				for (String a : split) {

					if (verbList.contains(a)) {
						wordPasser = a;
						break;
					} else
						textBox.append("\nThat is not a verb I recognize");
					break;
				}
			}
		}

	}

	public String returnWords() {
		return wordPasser;
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
