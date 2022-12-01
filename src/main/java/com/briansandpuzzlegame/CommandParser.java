package com.briansandpuzzlegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class CommandParser implements KeyListener {
    // Parser wordlists
    List<String> verbList;
    List<String> adverbList;

    // UI instance
    RoomUI roomUI;

    /**
     * Constructs a CommandParser with the provided RoomUI. 
     * Initializes word lists.
     */
    public CommandParser(RoomUI roomUI) {
        super();
        verbs();
        adverbs();
        this.roomUI = roomUI;
    }

    /**
     * Parser verbs list
     */
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

    /**
     * Parser adverbs list
     */
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

    /**
     * keyPressed
     * 
     * If the user hits enter, sends the entered line of text to the main RoomUI
     */
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == roomUI.inputBox) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_ENTER) {

                String words = roomUI.inputBox.getText();
                roomUI.inputBox.setText("");

                String result = roomUI.processInput(words); 
                roomUI.textBox.append(result + "\n");
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
