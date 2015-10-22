package org.univoulu.tol.sqatlab.gameoflife;

import java.util.ArrayList;
import java.util.Random;

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
	
	public void initializeGrid(double d) {
		Random r = new Random();
		
		for (int x = 0; x < size; x++) {
			
			for (int y = 0; y < size; y++) {
				double c = r.nextDouble();
				
				cells[x][y] = new Cell(x + "" + y);
				
				if (c <= d) {
					cells[x][y].setState(true);
				}
			}
		}
	}
		
	public void setAlive(int i, int i1) {
        if (i >= 0 && i < size && i1 >= 0 && i1 < size) {
        	cells[i][i1].setState(true);
        }
    }
	
	public void setDead(int i, int i1) {
        if (i >= 0 && i < size && i1 >= 0 && i1 < size) {
        	cells[i][i1].setState(false);
        }
    }
	
	
	public void updateGrid() {
		int[][] aliveNeighbourCountTable = this.getAliveNeighboursCountToTable();
		for (int x = 0; x < size; x++) {
			
			for (int y = 0; y < size; y++) {
				
				try {
					this.updateCell(x, y, aliveNeighbourCountTable[x][y]);
				
				} catch(CustomLifeException e){
					System.out.println("Custom Life Exception occurred");
				}
			}
		}
	}
	
	public void drawGrid() {

		for (int y = 0; y < size; y++) {
			
			for (int x = 0; x < size; x++) {
				
				try {
				Cell cell = getCell(x, y);
	
				if (cell.getState())
					System.out.print("X");
				else
					System.out.print("-");
				
				if ( (x+1) == size)
					System.out.println("");
	
				} catch(Exception e){}		
			}
		}
		System.out.println("");
	}
	
	public ArrayList<Cell> getNeighbours(int i, int i1) {
		ArrayList<Cell> neighbours = new ArrayList<>();
		
		Cell targetCell = null;
		try {
			targetCell = getCell(i, i1);
		} catch (Exception e){}
		
		
		for (int x = i - 1; x < i + 2; x++) {
			for (int y = i1 - 1; y < i1 + 2; y++ ) {
			
				Cell cell;
				
				try {
					cell = getCell(x, y);
					
					if (!cell.getName().equalsIgnoreCase(targetCell.getName())) {
							neighbours.add(cell);
					}
					
				} catch (CustomLifeException e){}
			}
		}
		
		return neighbours;
	}
	
	public int[][] getAliveNeighboursCountToTable() {
			
		int[][] ret = new int[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {

            	ret[x][y] = this.getAliveNeighboursCount(x, y);
            }
        }
        
        return ret;
	}
	
	public int getAliveNeighboursCount(int i, int i1) {
		ArrayList<Cell> neighbours = new ArrayList<>();
		Cell targetCell = null;
		try {
			targetCell = getCell(i, i1);
		} catch (Exception e){}
		
		
		for (int x = i - 1; x < i + 2; x++) {
			for (int y = i1 - 1; y < i1 + 2; y++ ) {
			
				try {
					Cell cell = getCell(x,y);
					
					if (!cell.getName().equals(targetCell.getName())) {
						
						if (cell.getState())
							neighbours.add(cell);
						
					}
				} catch(Exception e){}
			}
		}
		
		return neighbours.size();
	}
	
	public void updateCell(int x, int y, int aliveNeighbours) throws CustomLifeException {
		
        if (getCell(x,y).getState()) {
            if (aliveNeighbours < 2) {
                this.setDead(x, y);
            }
            if (aliveNeighbours > 3) {
            	this.setDead(x, y);
            }
        } else {
            if (aliveNeighbours == 3) {
            	this.setAlive(x, y);
            }
        }
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
