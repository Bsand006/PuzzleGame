package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import org.json.JSONObject;

public interface IRoom {

	public void verbInterpreter() throws IOException;
	
	public void firstTimeRun();
	
	public void setParser(CommandParser p);

	public void enter();

	public void push();

	public void go();

	public void open();

	public void close();

	public void move();

	public void walk();

	public void use();

	public void turn();

	public void take();

	public void inspect();
	
	public void investigate();

	public void attack();

	public void climb();

	public void descend();

	public void run();

	public void hide();

	public void crawl();

	public void jump();

	public void search();

	public void look();

	public void check();

	public void touch();

	public void Throw();

	public void watch();

	public void Wait();

	public void Break();

	public void smash();
	
	public void put();
	
	public void place();
	
	public void remove();

	public void inventory();

	public void north();

	public void east();

	public void south();

	public void west();

	public void yes();

	public void no();

	public void leave();

	public void exit();
	
	public void spyglass();

	public void Continue();

	public void repeat();

	public void save(StateTracker z);

	public void load(StateTracker z) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException ;
	
	public void loadCall(JSONObject params);
	
	public ArrayList<String> getInventory();

	public void setInventory(ArrayList<String> inventory);
	
	public void setTextBox(JTextArea textBox);

}
