package com.github.alarit.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MappedDictionaryTest {

	private MappedDictionary<Long> dictionary;
	
	@Before
	public void init() {
		dictionary = new MappedDictionary<>();
		dictionary.addWord(1L,"alessandro");
		dictionary.addWord(2L,"aid");
		dictionary.addWord(3L,"average");
		dictionary.addWord(4L,"america");
		dictionary.addWord(5L,"available");
		dictionary.addWord(6L,"axe");
		dictionary.addWord(7L,"sun");
		dictionary.addWord(8L,"run");
		dictionary.addWord(9L,"home");
		dictionary.addWord(10L,"honey");
		dictionary.addWord(11L,"hover");
		dictionary.addWord(12L,"house");
		dictionary.addWord(13L,"hour");
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
	
	@Test
	public void valuesTest() {
		Map<Long, String> map = dictionary.startsWithSubstring("ho");
		Set<Long> ids = new HashSet<>();
		ids.add(9L);
		ids.add(10L);
		ids.add(11L);
		ids.add(12L);
		ids.add(13L);
		assertEquals(map.size(), 5);
		assertEquals(map.keySet(), ids);
	}

}