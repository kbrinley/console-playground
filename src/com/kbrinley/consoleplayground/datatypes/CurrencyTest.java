package com.kbrinley.consoleplayground.datatypes;

import junit.framework.TestCase;

public class CurrencyTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDefaultConstructorSetsCurrencyToZero() {
		Currency testCurrency = new Currency();
		assertEquals("$0.00", testCurrency.toString());
	}
	
	public void testOneDollarFiftyCentsSetsCurrencyCorrectly() {
		Currency testCurrency = new Currency(true, 1L, 99);
		assertEquals("$1.99", testCurrency.toString());
	}
	
	public void testOneDollarFiveCentsSetsCurrencyCorrectly() {
		Currency testCurrency = new Currency(true, 1L, 5);
		assertEquals("$1.05", testCurrency.toString());
	}
	
	
	public void testCentsCannotExceed99() {
		try {
			Currency testCurrency = new Currency(true, 0L, 100);
			fail("Exception should have been thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Cents must be between 0 and 100", e.getMessage());
		}
	}
	
	public void testCentsCannotBeBelow0() {
		try {
			Currency testCurrency = new Currency(true, 0L, -1);
			fail("Exception should have been thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Cents must be between 0 and 100", e.getMessage());
		}
	}
	
	public void testDollarsCannotBeBelow0() {
		try {
			Currency testCurrency = new Currency(true, -1L, 1);
			fail("Exception should have been thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Dollars must be positive", e.getMessage());
		}
	}
}
