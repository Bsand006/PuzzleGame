package com.briansandpuzzlegame;

import java.util.List;

public interface IRoom {

	public void verbInterpreter();

	public void enter();

	public void push();

	public void go();

	public void open();

	public void close();

	public void move();

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

	public void Continue();

	public List<String> getInventory();

	public void setInventory(List<String> inventory);

}
