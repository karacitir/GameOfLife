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
	
	public ArrayList<Cell> getNeighbours(int i1, int i2) {
		ArrayList<Cell> neighbours = new ArrayList<>();
		
		for (int x = i1 - 1; x < i1 + 2; x++) {
			for (int y = i2 - 1; y < i2 + 2; y++ ) {
			
				Cell cell = cells[x][y];
				System.out.println(x + " " + y);
				
				
					neighbours.add(cell);
			}
		}
		
		return neighbours;
	}
	
	public Cell[][] getCells() {
		return cells;
	}
}
