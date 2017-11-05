package com.github.alarit.engine;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.alarit.model.Trie;
import com.github.alarit.util.StringUtils;

public class MappedDictionary<T> {
	
	private Trie trie;
	private Set<String> words;
	private Map<Integer,T> mappedWords;
	private boolean caseSensitive;
	
	public MappedDictionary(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
		trie = new Trie();
		mappedWords = new HashMap<>();
		words = new HashSet<>();
	}
	
	public MappedDictionary() {
		trie = new Trie();
		mappedWords = new HashMap<>();
		words = new HashSet<>();
	}
	
	public void addWord(T value, String word) {
		if(StringUtils.notEmpty(word)) {
			String wordToAdd = getWordCaseSensitive(word);
			
			if(!words.contains(wordToAdd)) {
				int wordHashCode = wordToAdd.hashCode();
				trie.addWord(wordToAdd);
				words.add(wordToAdd);
				mappedWords.put(wordHashCode, value);
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
	
	public Map<T,String> startsWithSubstring(String word) {
		String wordToFind = getWordCaseSensitive(word);
		return trie.startsWithWord(wordToFind)
				.stream()
				.collect(Collectors.toMap(w -> mappedWords.get((wordToFind + w).hashCode()), w-> word + w));
	}
	
	private String getWordCaseSensitive(String word) {
		return caseSensitive? word : word.toLowerCase();
	}
}
