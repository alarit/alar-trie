package com.github.alarit.engine;

import java.util.HashSet;
import java.util.Set;

import com.github.alarit.model.Letter;
import com.github.alarit.model.Trie;

public class Dictionary {
	
	private Trie trie;
	private Set<String> words;
	
	public Dictionary() {
		trie = new Trie();
		words = new HashSet<>();
		Letter root = new Letter(' ', false);

		trie.setRoot(root);
	}
	
	public void addWord(String word) {
		/*
		 * FIXME Add regexp excluding special chars
		 */
		String lCaseWord = word.toLowerCase();
		if(! words.contains(lCaseWord)) {
			trie.addWord(lCaseWord);
			words.add(lCaseWord);
		}
	}
	
	public Set<String> getWords() {
		return words;
	}
	
	public boolean containsWord(String word) {
		return words.contains(word.toLowerCase());
	}
}
