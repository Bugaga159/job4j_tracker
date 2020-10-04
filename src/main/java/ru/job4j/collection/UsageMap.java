package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("test@test.com", "Pupkin Ivan Sergeevich");
		map.put("dark@mail.ru", "Giga Albert");
		map.put("true@gmail.com", "Panin Andrey");
		for (String key: map.keySet()) {
			String value = map.get(key);
			System.out.println(key + " = " + value);
		}
	}
}
