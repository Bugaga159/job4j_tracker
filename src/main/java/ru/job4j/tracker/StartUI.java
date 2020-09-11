package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		tracker.add(new Item());
		tracker.add(new Item());
		tracker.add(new Item());
		tracker.add(new Item());
		Item findById = tracker.findById(3);
		System.out.println(findById);
		findById = tracker.findById(5);
		System.out.println(findById);
	}
}
