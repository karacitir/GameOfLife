package org.univoulu.tol.sqatlab.gameoflife;

public class Cell {

	private boolean alive = false;
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public boolean getAlive() {
		return alive;
	}
	
	public void update() {
		this.alive = false;
	}
}
