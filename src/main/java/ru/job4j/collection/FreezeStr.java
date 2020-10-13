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
}