package com.briansandpuzzlegame;

/**
 * Each room type implements this class
 */
public interface IRoom {

	public void doEnter();

	public void doGo();

	public void doOpen();

	public void doClose();

	public void doMove();

	public void doUse();

	public void doTurn();

	public void doTake();

	public void doInspect();

	public void doAttack();

	public void doClimb();

	public void doDescend();

	public void doRun();

	public void doHide();

	public void doCrawl();

	public void doJump();

	public void doSearch();

	public void doLook();

	public void doCheck();

	public void doTouch();

	public void doThrow();

	public void doWatch();

	public void doWait();

	public void doBreak();

	public void doSmash();

	public void doInventory();

	public void goNorth();

	public void goEast();

	public void goSouth();

	public void goWest();

}
