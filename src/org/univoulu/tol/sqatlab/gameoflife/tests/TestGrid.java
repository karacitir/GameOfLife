package org.univoulu.tol.sqatlab.gameoflife.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.univoulu.tol.sqatlab.gameoflife.Grid;

public class TestGrid {

	private Grid grid;
	
	@Before
	public void setup() {
		grid = new Grid();
	}
	
	@Test
	public void testCreateGrid30by30() {
		assertEquals(30, grid.getSize());
	}

}
