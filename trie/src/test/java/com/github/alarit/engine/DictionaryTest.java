package com.github.alarit.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {

	private Dictionary dictionary;
	
	@Before
	public void init() {
		dictionary = new Dictionary();
		dictionary.addWord("alessandro");
		dictionary.addWord("aid");
		dictionary.addWord("average");
		dictionary.addWord("america");
		dictionary.addWord("available");
		dictionary.addWord("axe");
		dictionary.addWord("sun");
		dictionary.addWord("run");
		dictionary.addWord("home");
		dictionary.addWord("honey");
		dictionary.addWord("hover");
		dictionary.addWord("house");
		dictionary.addWord("hour");
	}
	
	@Test
	public void dictionarySizeTest() {
		assertEquals(13, dictionary.getAllWords().size());
	}
	
	@Test
	public void containsWordTest() {
		assertTrue(dictionary.containsWord("sun"));
		assertFalse(dictionary.containsWord("tablet"));
	}
	
	@Test
	public void startsWithTest() {
		assertEquals(dictionary.startsWithSubstring("ho").size(), 5);
		assertEquals(dictionary.startsWithSubstring("a").size(), 6);
		assertEquals(dictionary.startsWithSubstring("s").size(), 1);
		assertTrue(dictionary.startsWithSubstring("x").isEmpty());
	}

}