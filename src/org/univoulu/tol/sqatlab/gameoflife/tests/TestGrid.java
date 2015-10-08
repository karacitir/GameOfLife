package org.univoulu.tol.sqatlab.gameoflife.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.univoulu.tol.sqatlab.gameoflife.Cell;
import org.univoulu.tol.sqatlab.gameoflife.Grid;

public class TestGrid {

	private Grid grid;
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	@Before
	public void setup() {
		grid = new Grid(10);
		grid.initializeGrid();
	}
	
	@Test
	public void testCreateGrid30by30() {
		grid.setSize(30);
		assertEquals(30, grid.getSize());
		assertEquals(30, grid.getCells().length);
	}

	@Test
	public void testFindNeighbours() {
		ArrayList<Cell> neighbours = grid.getNeighbours(1, 1);
		assertEquals(8, neighbours.size());
		
	}
	
	@Test
	public void testFindAliveNeighboursOne() {
		ArrayList<Cell> neighbours = grid.getNeighbours(1, 1);
		neighbours.get(0).setState(true);
		ArrayList<Cell> aliveNeighbours = grid.getAliveNeighbours(1, 1);
		assertEquals(1, aliveNeighbours.size());
	}
	
	@Test(expected = Exception.class)
	public void testGetCellFromGridException() throws Exception {
		Cell cell = grid.getCell(-1, 0);
      
	}
}
