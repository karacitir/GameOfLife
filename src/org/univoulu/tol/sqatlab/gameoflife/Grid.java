package org.univoulu.tol.sqatlab.gameoflife;

public class Grid {

	private Cell[][] cells;
	private int size;
	
	public Grid(int size) {
		cells = new Cell[size][size];
		this.size = size;
	}
	
	public void setSize(int size) {
		cells = new Cell[size][size];
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	
	public void initializeGrid() {
		
	}
	
	public Cell[][] getNeighbours(int x, int y) {
		
	}
	
	public Cell[][] getCells() {
		return cells;
	}
}
