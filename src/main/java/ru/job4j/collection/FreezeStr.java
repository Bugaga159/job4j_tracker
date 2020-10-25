package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
	public static boolean eq(String left, String right) {
		if (left.length() != right.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char k: left.toCharArray()) {
			map.computeIfPresent(k, (key, value) -> value + 1);
			map.putIfAbsent(k, 1);
		}
		for (char k: right.toCharArray()) {
			map.computeIfPresent(k, (key, value) -> value - 1);
			map.remove(k, 0);
		}
		return map.size() == 0;
	}
}