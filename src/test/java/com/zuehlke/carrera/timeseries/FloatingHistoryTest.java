package com.zuehlke.carrera.timeseries;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FloatingHistoryTest {

	@Test
	public void testInOrder1() {
		FloatingHistory history = new FloatingHistory(8);
		history.shift(1.0);
		history.shift(2.0);
		history.shift(3.0);
		history.shift(4.0);
		history.shift(5.0);
		history.shift(6.0);
		history.shift(7.0);
		history.shift(8.0);
		assertTrue(history.valuesInOrder());
	}

	@Test
	public void testInOrder2() {
		FloatingHistory history = new FloatingHistory(8);
		history.shift(8.0);
		history.shift(7.0);
		history.shift(6.0);
		history.shift(5.0);
		history.shift(4.0);
		history.shift(3.0);
		history.shift(2.0);
		history.shift(1.0);
		assertTrue(history.valuesInOrder());
	}

	@Test
	public void testNotInOrder() {
		FloatingHistory history = new FloatingHistory(8);
		history.shift(2.0);
		history.shift(5.0);
		history.shift(1.0);
		history.shift(4.0);
		history.shift(2.0);
		history.shift(6.0);
		history.shift(8.0);
		history.shift(1.0);
		assertTrue(!history.valuesInOrder());
	}

}
