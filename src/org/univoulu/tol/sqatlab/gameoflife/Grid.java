package org.univoulu.tol.sqatlab.gameoflife;

import java.util.ArrayList;

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
		for (int x = 0; x < size; x++) {
			
			for (int y = 0; y < size; y++) {
				cells[x][y] = new Cell();
			}
		}
	}
	
	public ArrayList<Cell> getNeighbours(int i1, int i2) {
		ArrayList<Cell> neighbours = new ArrayList<>();
				
		for (int x = i1 - 1; x < i1 + 2; x++) {
			for (int y = i2 - 1; y < i2 + 2; y++ ) {
			
				if (x >= 0 && x < size && y >= 0 && y < size) {
				
					Cell cell = cells[x][y];
					
					neighbours.add(cell);
					
					if (x == i1 && y == i2) {
						neighbours.remove(cell);
					}
				}
			}
		}
		
		return neighbours;
	}
	
	public ArrayList<Cell> getAliveNeighbours(int i1, int i2) {
		ArrayList<Cell> neighbours = new ArrayList<>();
		
		for (int x = i1 - 1; x < i1 + 2; x++) {
			for (int y = i2 - 1; y < i2 + 2; y++ ) {
			
				Cell cell = cells[x][y];
				
				if (cell.getState()) {
					neighbours.add(cell);
					
					if (x == i1 && y == i2) {
						neighbours.remove(cell);
					}
				}
			}
		}
		
		return neighbours;
	}
	
	public Cell getCell(int x, int y) throws Exception {
		if (x < 0 || x >= size || y < 0 || y >= size)
			throw new Exception("Exception");
		
		return cells[x][y];
	}
	
	public Cell[][] getCells() {
		return cells;
	}
}
