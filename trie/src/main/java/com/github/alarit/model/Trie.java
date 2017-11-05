package com.github.alarit.model;

import java.util.HashSet;
import java.util.Set;

import com.github.alarit.util.StringUtils;

public class Trie {
	
	private Letter root;
	private static final int DELTA_FIRST_POS = (int)'A';
	private static final int DELTA_LAST_POS = (int)'z' - DELTA_FIRST_POS + 1; 
	
	public Trie() {
		root = new Letter(' ', false, DELTA_LAST_POS);
	}
	
	public Letter getRoot() {
		return root;
	}

	public void setRoot(Letter root) {
		this.root = root;
	}
	
	public void addWord(String word) {
		if(StringUtils.notEmpty(word)) {
			addWord(word, root);
		}
	}
	
	public Set<String> startsWithWord(String word) {
		if(StringUtils.notEmpty(word)) {
			root.getNextChars();
			Letter subwordRoot = checkSubwordExists(root, word);
			if(subwordRoot != root) {
				return findSubwordsFrom(subwordRoot);
			}
		}
		return new HashSet<>();
	}
	
	private int getCharIndex(char c) {
		return ((int) c) - DELTA_FIRST_POS;
	}

	private void addWord(String word, Letter subroot) {
		if(StringUtils.notEmpty(word)) {
			Letter[] rootNextChars = subroot.getNextChars();
			int index = getCharIndex(word.charAt(0));
			boolean isLast = word.length() == 1;
			if(rootNextChars[index] == null || (isLast && !rootNextChars[index].isLast())) {
				Letter l = new Letter(word.charAt(0), isLast, DELTA_LAST_POS);
				rootNextChars[index] = l;
			}
			addWord(word.substring(1), rootNextChars[index]);
		}
	}
	
	private Letter checkSubwordExists(Letter currentRoot, String word) {
		if(StringUtils.notEmpty(word)) {
			Letter[] letters = currentRoot.getNextChars();
			int index = getCharIndex(word.charAt(0));
			if(letters[index] != null) {
				currentRoot = checkSubwordExists(letters[index], word.substring(1));
			}
		}
		return currentRoot;
	}
	
	private Set<String> findSubwordsFrom(Letter root) {
		Set<String> set = new HashSet<>();
		findSubwordsFrom(root, set, "");
		return set;
	}
	
	private Set<String> findSubwordsFrom(Letter root, Set<String> subwords, String prevChars) {
		for(Letter letter : root.getNextChars()) {
			String tmpSubword = prevChars;
			if(letter != null) {
				tmpSubword += letter.getValue();
				if(letter.isLast()) {
					subwords.add(tmpSubword);
				}
				findSubwordsFrom(letter, subwords, tmpSubword);
			}
		}
		return subwords;
	}
}