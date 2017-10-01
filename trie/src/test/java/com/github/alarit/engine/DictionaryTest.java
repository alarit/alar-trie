package com.github.alarit.engine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {

	private Dictionary dictionary;
	
	@Before
	public void init() {
		dictionary = new Dictionary();
	}
	
	@Test
	public void test() {
		dictionary.addWord("home");
		dictionary.addWord("house");
		dictionary.addWord("sun");
		assertEquals(3, dictionary.getWords().size());
	}

}
