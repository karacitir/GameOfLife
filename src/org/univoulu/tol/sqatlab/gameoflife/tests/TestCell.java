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
		assertEquals(1, cell.getAlive());
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
