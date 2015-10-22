package org.univoulu.tol.sqatlab.gameoflife;

public class Cell {

	private boolean state = false;
	private String name;
	
	public Cell(String name) {
		this.name = name;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean getState() {
		return state;
	}
	
	public String getName() {
		return name;
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
