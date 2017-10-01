package com.github.alarit.model;

public class Letter {

	private char value;
	private boolean isLast;
	private Letter[] nextChars;
	
	public Letter(char value, boolean isLast) {
		super();
		this.value = value;
		this.isLast = isLast;
		nextChars = new Letter[26]; 
	}

	public Letter[] getNextChars() {
		return nextChars;
	}

	public void setNextChars(Letter[] nextChars) {
		this.nextChars = nextChars;
	}

	public char getValue() {
		return value;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}
}
