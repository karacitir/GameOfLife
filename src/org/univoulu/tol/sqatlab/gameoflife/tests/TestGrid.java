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
		grid.initializeGrid();
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
	public void testFindAliveNeighboursOne() {
		ArrayList<Cell> neighbours = grid.getNeighbours(1, 1);
		neighbours.get(0).setState(true);
		ArrayList<Cell> aliveNeighbours = grid.getAliveNeighbours(1, 1);
		assertEquals(1, aliveNeighbours.size());
	}
	
	@Test(expected=CustomLifeException.class)
	public void testGetCellFromGridException() throws Exception {
		Cell cell = grid.getCell(-1, 0);		
	}
}
