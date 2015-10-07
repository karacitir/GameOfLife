package org.univoulu.tol.sqatlab.gameoflife.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.univoulu.tol.sqatlab.gameoflife.Cell;

public class TestCell {

	private Cell cell;
	
	@Before
	public void setup() {
		cell = new Cell();
	}
	
	@Test
	public void testAlive() {
		cell.setState(true);
		assertTrue(cell.getState());
	}
	
	@Test 
	public void testCellUpdateWithNoNeighbours() {
		cell.setState(true);
		cell.update(0);
		assertFalse(cell.getState());	
	}

	@Test 
	public void testCellUpdateWithTwoNeighboursStayAlive() {
		cell.setState(true);
		cell.update(2);
		assertTrue(cell.getState());	
	}
}
