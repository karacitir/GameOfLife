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
	
	public List<Cell> getNeighbours(int x, int y) {
		List<Cell> neighbours = new ArrayList<>();
		return neighbours;
	}
	
	public Cell[][] getCells() {
		return cells;
	}
}
