package org.univoulu.tol.sqatlab.gameoflife.tests;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.univoulu.tol.sqatlab.gameoflife.Cell;
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
}
