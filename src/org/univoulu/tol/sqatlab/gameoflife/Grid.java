package org.univoulu.tol.sqatlab.gameoflife;

import java.util.ArrayList;
import java.util.List;

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
	
	public ArrayList<Cell> getNeighbours(int i, int i1) {
		ArrayList<Cell> neighbours = new ArrayList<>();
		
		for (int x = i - 1; x < i)
		
		
		return neighbours;
	}
	
	public Cell[][] getCells() {
		return cells;
	}
}
