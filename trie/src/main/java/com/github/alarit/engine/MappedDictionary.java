package com.github.alarit.engine;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.alarit.model.Trie;

public class MappedDictionary<T> {
	
	private Trie trie;
	private Set<String> words;
	private Map<Integer,T> mappedWords;
	
	public MappedDictionary() {
		trie = new Trie();
		mappedWords = new HashMap<>();
		words = new HashSet<>();
	}
	
	public void addWord(T value, String word) {
		if(!words.contains(word)) {
			int wordHashCode = word.hashCode();
			trie.addWord(word);
			words.add(word);
			mappedWords.put(wordHashCode, value);
		}
	}
	
	public Collection<String> getAllWords() {
		return words;
	}
	
	public boolean containsWord(String word) {
		return words.contains(word.toLowerCase());
	}
	
	public Map<T,String> startsWithSubstring(String word) {
		return trie.startsWithWord(word)
				.stream()
				.collect(Collectors.toMap(w -> mappedWords.get((word + w).hashCode()), w-> w));
	}
}
