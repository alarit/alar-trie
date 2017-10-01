package com.github.alarit.model;

import java.util.function.Predicate;

public class Trie {
	
	private Letter root;
	private Predicate<String> validWord = (w)-> w != null && !w.isEmpty();
	private static final int DELTA_POS = (int) 'a';
	
	public Letter getRoot() {
		return root;
	}

	public void setRoot(Letter root) {
		this.root = root;
	}
	
	public void addWord(String word) {
		if(validWord.test(word)) {
			addWord(word, root);
		}
	}
	
	private void addWord(String word, Letter subroot) {
		if(validWord.test(word)) {
			Letter[] rootNextChars = subroot.getNextChars();
			int index = ((int) word.charAt(0)) - DELTA_POS;
			boolean isLast = word.length() > 1;
			if(rootNextChars[index] == null || (isLast && !rootNextChars[index].isLast())) {
				Letter l = new Letter(word.charAt(0), isLast);
				rootNextChars[index] = l;
			}
			addWord(word.substring(1), rootNextChars[index]);
		}
	}
}
