package com.kbrinley.consoleplayground.datatypes;

import java.text.MessageFormat;

/*
 * Adapted from Data Structures, Algorithms, and Applications in Java
 */
public class Currency {

	public static final boolean POSITIVE = true;
	public static final boolean NEGATIVE = false;
	
	private static final String SYMBOL = "$";
	
	private boolean sign;
	private long dollars;
	private int cents;
	
	public Currency(boolean theSign, long theDollars, int theCents) {
		sign = theSign;
		setDollars(theDollars);
		setCents(theCents);
	}
	
	public Currency() {
		this(POSITIVE, 0L, 0);
	}
	
	public String toString() {
		Object[] currencyParts = {SYMBOL, Long.valueOf(dollars), Integer.valueOf(cents)};
		return String.format("%1$s%2$d.%3$02d", currencyParts);
	}

	private void setCents(int theCents) {
		if (theCents < 0 || theCents > 99)
			throw new IllegalArgumentException("Cents must be between 0 and 100");
		else
			cents = theCents;
	}

	private void setDollars(long theDollars) {
		if (theDollars < 0)
			throw new IllegalArgumentException("Dollars must be positive");
		else
			dollars = theDollars;
	}
}
