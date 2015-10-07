package org.univoulu.tol.sqatlab.gameoflife;

public class Cell {

	private boolean state = false;
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean getState() {
		return state;
	}
	
	public void update() {
		this.state = false;
	}
}
