package com.briansandpuzzlegame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RoomUI {
    CommandParser parser;
    // User input string
    String        words;

    // GUI variables
    JFrame      f;
    JTextArea   textBox;
    JTextField  inputBox;
    JScrollPane scroller;
    Font        font;

    public RoomUI() {
        parser = new CommandParser(this);
    }
    
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
        textBox.append("You stand in a dark room. You can see nothing in the darkness around you\n");

        inputBox = new JTextField();
        inputBox.setBounds(5, 454, 800, 50);

        // Scroller
        scroller = new JScrollPane(textBox);
        scroller.setBounds(3, 3, 800, 450);

        f.add(scroller);
        f.add(inputBox);

        inputBox.addKeyListener(parser);
    }

    public String processInput(String words) {
        System.out.println(words);
        
        String[] split = words.split(" ");
        System.out.println(split);

        String theverb = split[0];
        
        if (parser.verbList.contains(theverb)) {
            // DO SOMETHING HERE WITH THE VERB AND 2ND WORD
            return "You said '" + theverb + "'";
        }
        return("'" + theverb + "' is not a verb I recognize");
    }
    
    // Launches Program
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RoomUI().run();
            }
        });
    }
}
