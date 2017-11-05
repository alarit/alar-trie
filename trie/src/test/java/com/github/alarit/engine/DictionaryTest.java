package com.github.alarit.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {

	private Dictionary dictionaryNotCS;
	private Dictionary dictionaryCS;
	
	@Before
	public void init() {
		dictionaryNotCS = new Dictionary();
		dictionaryNotCS.addWord("alessandro");
		dictionaryNotCS.addWord("aid");
		dictionaryNotCS.addWord("average");
		dictionaryNotCS.addWord("america");
		dictionaryNotCS.addWord("available");
		dictionaryNotCS.addWord("axe");
		dictionaryNotCS.addWord("sun");
		dictionaryNotCS.addWord("fuzz");
		dictionaryNotCS.addWord("home");
		dictionaryNotCS.addWord("honey");
		dictionaryNotCS.addWord("hover");
		dictionaryNotCS.addWord("house");
		dictionaryNotCS.addWord("hour");
		
		dictionaryCS = new Dictionary(true);
		dictionaryCS.addWord("home");
		dictionaryCS.addWord("Honey");
		dictionaryCS.addWord("Hover");
		dictionaryCS.addWord("house");
		dictionaryCS.addWord("hour");
	}
	
	@Test
	public void dictionarySizeTest() {
		assertEquals(13, dictionaryNotCS.getAllWords().size());
		
		assertEquals(5, dictionaryCS.getAllWords().size());
	}
	
	@Test
	public void containsWordTest() {
		assertTrue(dictionaryNotCS.containsWord("sun"));
		assertFalse(dictionaryNotCS.containsWord("tablet"));
		
		assertTrue(dictionaryCS.containsWord("Honey"));
		assertFalse(dictionaryCS.containsWord("honey"));
	}
	
	@Test
	public void startsWithTest() {
		assertEquals(dictionaryNotCS.startsWithSubstring("ho").size(), 5);
		assertEquals(dictionaryNotCS.startsWithSubstring("a").size(), 6);
		assertEquals(dictionaryNotCS.startsWithSubstring("s").size(), 1);
		assertTrue(dictionaryNotCS.startsWithSubstring("x").isEmpty());
		
		assertEquals(dictionaryCS.startsWithSubstring("Ho").size(), 2);
		assertEquals(dictionaryCS.startsWithSubstring("ho").size(), 3);
		assertTrue(dictionaryCS.startsWithSubstring("x").isEmpty());
	}

}