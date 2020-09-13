package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
	public void printResult(boolean rst, int id) {
		System.out.println(rst
				? "--- SUCCESS ---"
				: "--- FAIL: id:" + id + " does not exist ---");
	}

	public void printResult(Item item) {
		System.out.println(item.getId() + " - " + item.getName());
	}

	public void init(Scanner scanner, Tracker tracker) {
		boolean run = true;
		while (run) {
			this.showMenu();
			int select = Integer.valueOf(scanner.nextLine());
			if (select == 0) {
				System.out.println("--- Create a new Item ---");
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				Item item = new Item(name);
				tracker.add(item);
			} else if (select == 1) {
				System.out.println("--- Show all Items ---");
				Item[] items = tracker.findAll();
				if (items.length == 0) {
					System.out.println("null");
				} else {
					for (Item item: items) {
						printResult(item);
					}
				}
			} else if (select == 2) {
				System.out.println("--- Edit item ---");
				System.out.println("--- Input id of item ---");
				int id = Integer.valueOf(scanner.nextLine());
				System.out.println("--- Input name to item ---");
				String name = scanner.nextLine();
				Item repItem = new Item(name);
				printResult(tracker.replace(id, repItem), id);
			} else if (select == 3) {
				System.out.println("--- Delete item ---");
				System.out.println("--- Input id of item ---");
				int id = Integer.valueOf(scanner.nextLine());
				printResult(tracker.delete(id), id);
			} else if (select == 4) {
				System.out.println("--- Find item by Id ---");
				System.out.println("--- Input id of item ---");
				int id = Integer.valueOf(scanner.nextLine());
				Item rsl = tracker.findById(id);
				if (rsl == null) {
					System.out.println("Заявка с таким id не найдена");
				} else {
					printResult(rsl);
				}
			} else if (select == 5) {
				System.out.println("--- Find items by name ---");
				System.out.println("--- Input the name of items ---");
				String name = scanner.nextLine();
				Item[] items = tracker.findByName(name);
				if (items.length == 0) {
					System.out.println("Заявки с таким именем не найдены");
				} else {
					for (Item item: items) {
						printResult(item);
					}
				}
			} else if (select == 6) {
				System.out.println("--- Goodbye ---");
				run = false;
			}
		}
	}

	private void showMenu() {
		System.out.println("Menu." + System.lineSeparator()
				+ "0. Add new Item" + System.lineSeparator()
				+ "1. Show all items" + System.lineSeparator()
				+ "2. Edit item" + System.lineSeparator()
				+ "3. Delete item" + System.lineSeparator()
				+ "4. Find item by Id" + System.lineSeparator()
				+ "5. Find items by name" + System.lineSeparator()
				+ "6. Exit Program" + System.lineSeparator()
				+ "Select:");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Tracker tracker = new Tracker();
		new StartUI().init(scanner, tracker);
	}
}
