package org.univoulu.tol.sqatlab.gameoflife.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.univoulu.tol.sqatlab.gameoflife.Cell;
import org.univoulu.tol.sqatlab.gameoflife.CustomLifeException;
import org.univoulu.tol.sqatlab.gameoflife.Grid;

public class TestGrid {

	private Grid grid;
	
	@Before
	public void setup() {
		grid = new Grid(10);
		grid.initializeGrid(0.0);
	}
	
	@Test
	public void testCreateGrid30by30() {
		grid.setSize(30);
		assertEquals(30, grid.getSize());
		assertEquals(30, grid.getCells().length);
	}

	@Test
	public void testFindNeighboursXOneYOne() {
		ArrayList<Cell> neighbours = grid.getNeighbours(1, 1);
		assertEquals(8, neighbours.size());
		
	}
	
	@Test
	public void testFindNeighboursXZeroYZero() {
		ArrayList<Cell> neighbours = grid.getNeighbours(0, 0);
		assertEquals(3, neighbours.size());
		
	}
	
	@Test
	public void testFindAliveNeighboursOne() throws Exception {
		grid.getCell(0, 0).setState(true);
		assertTrue(grid.getCell(0, 0).getState());
		assertEquals(1, grid.getAliveNeighboursCount(1, 1));
	}
	
	@Test(expected=CustomLifeException.class)
	public void testGetCellFromGridException() throws Exception {
		Cell cell = grid.getCell(-1, 0);		
		assertNull(cell);
	}
	
	@Test
	public void testUpdateGrid() {
		ArrayList<Cell> neighbours = grid.getNeighbours(3, 3);
		neighbours.get(1).setState(true);
		neighbours.get(4).setState(true);
		neighbours.get(5).setState(true);
		neighbours.get(6).setState(true);
		neighbours.get(7).setState(true);
		
		grid.drawGrid();
		
		grid.updateGrid();
		
		grid.drawGrid();
		
		neighbours = grid.getNeighbours(3, 3);

		assertFalse(neighbours.get(0).getState());
		assertFalse(neighbours.get(1).getState());
		assertFalse(neighbours.get(2).getState());
		assertTrue(neighbours.get(3).getState());
		assertTrue(neighbours.get(4).getState());
		assertFalse(neighbours.get(5).getState());
		assertTrue(neighbours.get(6).getState());
		assertTrue(neighbours.get(7).getState());
	}
}
