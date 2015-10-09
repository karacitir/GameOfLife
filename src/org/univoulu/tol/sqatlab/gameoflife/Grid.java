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
		for (int x = 0; x < size; x++) {
			
			for (int y = 0; y < size; y++) {
				cells[x][y] = new Cell();
			}
		}
	}
	
	public void updateGrid() {
		
		for (int x = 0; x < size; x++) {
			
			for (int y = 0; y < size; y++) {
				Cell cellToUpdate = null;
				try {
				cellToUpdate = getCell(x, y);
				List<Cell> aliveList = getAliveNeighbours(x, y);
				cellToUpdate.update(aliveList.size());
				
				} catch(Exception e){}
				
				if (cellToUpdate != null) {
					if (cellToUpdate.getState())
						System.out.print("X");
					else
						System.out.print("-");
					
					if ( (y+1) == size)
						System.out.println("");
				}
		
			}
		}
		
	}
	
	public void drawGrid() {
		
for (int x = 0; x < size; x++) {
			
			for (int y = 0; y < size; y++) {
				Cell cell = getCell(x, y);
				
				
				if (cell.getState())
					System.out.print("X");
				else
					System.out.print("-");
				
				if ( (y+1) == size)
					System.out.println("");
			
		
			}
		}

	}
	public ArrayList<Cell> getNeighbours(int i1, int i2) {
		ArrayList<Cell> neighbours = new ArrayList<>();
				
		for (int x = i1 - 1; x < i1 + 2; x++) {
			for (int y = i2 - 1; y < i2 + 2; y++ ) {
			
				Cell cell;
				
				try {
					cell = getCell(x, y);
					neighbours.add(cell);
					if (x == i1 && y == i2) {
						neighbours.remove(cell);
					}
					
				} catch (CustomLifeException e){}
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
	
	public Cell getCell(int x, int y) throws CustomLifeException {
		if (x < 0 || x >= size || y < 0 || y >= size)
			throw new CustomLifeException("Exception");
		
		return cells[x][y];
	}
	
	public Cell[][] getCells() {
		return cells;
	}
}
