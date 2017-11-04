package com.github.alarit.model;

class Letter {

	private char value;
	private boolean isLast;
	private Letter[] nextChars;

	public Letter(char value, boolean isLast) {
		super();
		this.value = value;
		this.isLast = isLast;
		nextChars = new Letter[26];
	}

	Letter[] getNextChars() {
		return nextChars;
	}

	void setNextChars(Letter[] nextChars) {
		this.nextChars = nextChars;
	}

	char getValue() {
		return value;
	}

	boolean isLast() {
		return isLast;
	}

	void setLast(boolean isLast) {
		this.isLast = isLast;
	}
}