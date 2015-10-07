package org.univoulu.tol.sqatlab.gameoflife;

public class Cell {

	private boolean state = false;
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean getState() {
		return state;
	}
	
	public void update(int aliveNeighbours) {
		if (aliveNeighbours < 2)
			this.state = false;
		else if (aliveNeighbours == 3)
			this.state = true;
		else if (aliveNeighbours > 3)
			this.state = false;
	}
}
