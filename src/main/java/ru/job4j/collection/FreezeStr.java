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
			for (char i: left.toCharArray()) {
				Integer count = !map.containsKey(i) ? 1 : map.get(i) + 1;
				map.put(i, count);
			}
			for (char rChar: right.toCharArray()) {
				if (!map.containsKey(rChar) || map.get(rChar) == 0) {
					return false;
				}
				map.put(rChar, map.get(rChar) - 1);
			}
		}
		return rsl;
	}
}