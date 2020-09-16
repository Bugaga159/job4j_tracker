package ru.job4j.tracker;

public class PrintResult {
	public static void printResult(Item item) {
		System.out.println(item.getId() + " - " + item.getName());
	}

	public static void printResult(boolean rst, int id) {
		System.out.println(rst
				? "--- SUCCESS ---"
				: "--- FAIL: id:" + id + " does not exist ---");
	}
}
