package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		String[] buf = o1.split("/");
		String[] buf1 = o2.split("/");
		int rsl = buf1[0].compareTo(buf[0]);
		if (rsl == 0) {
			return o1.compareTo(o2);
		}
		return rsl;
	}
}