package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class Article {
	public static boolean generateBy(String origin, String line) {
		boolean rsl = true;
		origin = origin.replaceAll("\\p{P}", "");
		String[] originArr = origin.split(" ");
		String[] lineArr = line.split(" ");
		Set<String> originSet = new HashSet<>();
		for (String word: originArr) {
			originSet.add(word);
		}
		for (String wordInLine: lineArr) {
			if (!originSet.contains(wordInLine)) {
				rsl = false;
				break;
			}
		}
		return rsl;
	}
}