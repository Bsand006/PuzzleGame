package com.briansandpuzzlegame;

import java.io.IOException;
import java.util.List;

public interface IRoom {

	public void verbInterpreter() throws IOException;

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

	public void inventory();

	public void north();

	public void east();

	public void south();

	public void west();

	public void yes();

	public void no();
	
	public void leave();
	
	public void exit();

	public void Continue();
	
	public void save() throws IOException;
	
	public void load() throws IOException;
	
	public void repeat();

	public List<String> getInventory();

	public void setInventory(List<String> inventory);

}
