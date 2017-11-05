package com.github.alarit.util;

import java.util.function.Predicate;

public final class StringUtils {
	
	private StringUtils() {	}
	private static Predicate<String> notEmpty = w -> w != null && !w.isEmpty();

	public static boolean notEmpty(String word) {
		return notEmpty.test(word);
	}
}
