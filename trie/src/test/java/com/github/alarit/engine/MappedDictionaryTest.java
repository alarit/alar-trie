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

	private MappedDictionary<Long> dictionaryNotCS;
	private MappedDictionary<Long> dictionaryCS;
	
	@Before
	public void init() {
		dictionaryNotCS = new MappedDictionary<>();
		dictionaryNotCS.addWord(1L,"alessandro");
		dictionaryNotCS.addWord(2L,"aid");
		dictionaryNotCS.addWord(3L,"average");
		dictionaryNotCS.addWord(4L,"america");
		dictionaryNotCS.addWord(5L,"available");
		dictionaryNotCS.addWord(6L,"axe");
		dictionaryNotCS.addWord(7L,"sun");
		dictionaryNotCS.addWord(8L,"run");
		dictionaryNotCS.addWord(9L,"home");
		dictionaryNotCS.addWord(10L,"honey");
		dictionaryNotCS.addWord(11L,"hover");
		dictionaryNotCS.addWord(12L,"house");
		dictionaryNotCS.addWord(13L,"hour");
		
		dictionaryCS = new MappedDictionary<>(true);
		dictionaryCS.addWord(9L,"home");
		dictionaryCS.addWord(10L,"Honey");
		dictionaryCS.addWord(11L,"Hover");
		dictionaryCS.addWord(12L,"house");
		dictionaryCS.addWord(13L,"hour");
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
	
	@Test
	public void valuesTest() {
		Map<Long, String> map = dictionaryNotCS.startsWithSubstring("ho");
		Set<Long> ids = new HashSet<>();
		ids.add(9L);
		ids.add(10L);
		ids.add(11L);
		ids.add(12L);
		ids.add(13L);
		assertEquals(map.size(), 5);
		assertEquals(map.keySet(), ids);
		
		map = dictionaryCS.startsWithSubstring("ho");
		ids.clear();
		ids.add(9L);
		ids.add(12L);
		ids.add(13L);
		assertEquals(map.size(), 3);
		assertEquals(map.keySet(), ids);
	}

}