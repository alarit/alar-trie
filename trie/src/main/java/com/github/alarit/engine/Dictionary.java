package com.github.alarit.engine;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.github.alarit.model.Trie;

public class Dictionary {
	
	private Trie trie;
	private Set<String> words;
	
	public Dictionary() {
		trie = new Trie();
		words = new HashSet<>();
	}
	
	public void addWord(String word) {
		/*
		 * FIXME Add regexp checking unsopported chars
		 */
		if(!words.contains(word)) {
			trie.addWord(word);
			words.add(word);
		}
	}
	
	public Collection<String> getAllWords() {
		return words;
	}
	
	public boolean containsWord(String word) {
		return words.contains(word.toLowerCase());
	}
	
	public Collection<String> startsWithSubstring(String word) {
		return trie.startsWithWord(word);
	}
}
