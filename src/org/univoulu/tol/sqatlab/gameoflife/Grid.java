package org.univoulu.tol.sqatlab.gameoflife;

public class Grid {

	private Cell[][] cells;
	private int size;
	
	public Grid(int size) {
		cells = new Cell[size][size];
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	public Cell[][] getCells() {
		return cells;
	}
}
