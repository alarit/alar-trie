package com.github.alarit.engine;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.alarit.model.Trie;
import com.github.alarit.util.StringUtils;

public class Dictionary {
	
	private Trie trie;
	private Set<String> words;
	private boolean caseSensitive;
	
	public Dictionary(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
		trie = new Trie();
		words = new HashSet<>();
	}
	
	public Dictionary() {
		trie = new Trie();
		words = new HashSet<>();
	}
	
	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	public void addWord(String word) {
		if(StringUtils.notEmpty(word)) {
			String wordToAdd = getWordCaseSensitive(word);
			/*
			 * FIXME Add regexp checking unsopported chars
			 */
			if(!words.contains(wordToAdd)) {
				trie.addWord(wordToAdd);
				words.add(wordToAdd);
			}
		}
	}
	
	public Collection<String> getAllWords() {
		return words;
	}
	
	public boolean containsWord(String word) {
		String wordToFind = getWordCaseSensitive(word);
		return words.contains(wordToFind);
	}
	
	public Collection<String> startsWithSubstring(String word) {
		String wordToFind = getWordCaseSensitive(word);
		return trie.startsWithWord(wordToFind)
				.stream()
				.map( w -> word + w)
				.collect(Collectors.toSet());
	}
	
	private String getWordCaseSensitive(String word) {
		return caseSensitive? word : word.toLowerCase();
	}
}
