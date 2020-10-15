package ru.job4j.collection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FreezeStr {
	public static boolean eq(String left, String right) {
		boolean rsl = true;
		String[] leftArr = left.split("");
		String[] rightArr = right.split("");
		LinkedList<String> leftList = new LinkedList<>();
		for (String text: leftArr) {
			leftList.add(text);
		}
		for (String text: rightArr) {
			if (!leftList.contains(text)) {
				rsl = false;
				break;
			}
			leftList.remove(text);
		}
		return rsl;
	}

	public static boolean eqWithHashMap(String left, String right) {
		boolean rsl = false;
		if (left.length() == right.length()) {
			rsl = true;
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < left.length(); i++) {
				Character word = left.charAt(i);
				if (!map.containsKey(word)) {
					map.put(word, 1);
				} else {
					Integer value = map.get(word) + 1;
					map.put(word, value);
				}
			}
			for (int i = 0; i < right.length(); i++) {
				Character word = right.charAt(i);
				if (!map.containsKey(word)) {
					rsl = false;
					break;
				}
				if (map.get(word) == 0) {
					rsl = false;
					break;
				}
				map.put(word, map.get(word) - 1);
			}
		}
		return rsl;
	}
}