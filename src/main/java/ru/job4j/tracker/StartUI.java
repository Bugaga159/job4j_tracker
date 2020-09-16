package ru.job4j.tracker;

public class StartUI {

	public static void printResult(boolean rst, int id) {
		System.out.println(rst
				? "--- SUCCESS ---"
				: "--- FAIL: id:" + id + " does not exist ---");
	}

	public static void createItem(Input input, Tracker tracker) {
		System.out.println("--- Create a new Item ---");
		String name = input.askStr("Enter name: ");
		Item item = new Item(name);
		tracker.add(item);
    }

	public static void replaceItem(Input input, Tracker tracker) {
		System.out.println(" === Update item ====");
		int id = input.askInt("Enter id:");
		String name = input.askStr("Enter a new name of item: ");
		Item item = new Item(name);
		item.setId(id);
		tracker.replace(id, item);
	}

	public static void deteleItem(Input input, Tracker tracker) {
		System.out.println("--- Delete item ---");
		int id = input.askInt("--- Input id of item ---");
		printResult(tracker.delete(id), id);
	}

	public static void showAllItem(Tracker tracker) {
		System.out.println("--- Show all Items ---");
		Item[] items = tracker.findAll();
		if (items.length == 0) {
			System.out.println("null");
		} else {
			for (Item item: items) {
				StartUI.printResult(item);
			}
		}
	}

	public static void findById(Input input, Tracker tracker) {
		System.out.println("--- Find item by Id ---");
		int id = input.askInt("--- Input id of item ---");
		Item rsl = tracker.findById(id);
		if (rsl == null) {
			System.out.println("Заявка с таким id не найдена");
		} else {
			printResult(rsl);
		}
	}

	public static void findByName(Input input, Tracker tracker) {
		System.out.println("--- Find items by name ---");
		String name = input.askStr("--- Input the name of items ---");
		Item[] items = tracker.findByName(name);
		if (items.length == 0) {
			System.out.println("Заявки с таким именем не найдены");
		} else {
			for (Item item: items) {
				printResult(item);
			}
		}
	}

	public static boolean exitApp() {
		System.out.println("--- Goodbye ---");
		return false;
	}

	public static void printResult(Item item) {
		System.out.println(item.getId() + " - " + item.getName());
	}

	public void init(Input input, Tracker tracker) {
		boolean run = true;
		while (run) {
			this.showMenu();
			int select = Integer.valueOf(input.askStr("Select:"));
			if (select == 0) {
				StartUI.createItem(input, tracker);
			} else if (select == 1) {
				StartUI.showAllItem(tracker);
			} else if (select == 2) {
				StartUI.replaceItem(input, tracker);
			} else if (select == 3) {
				StartUI.deteleItem(input, tracker);
			} else if (select == 4) {
				StartUI.findById(input, tracker);
			} else if (select == 5) {
				StartUI.findByName(input, tracker);
			} else if (select == 6) {
				run = StartUI.exitApp();
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
				+ "6. Exit Program" + System.lineSeparator());
	}

	public static void main(String[] args) {
		Input input = new ConsoleInput();
		Tracker tracker = new Tracker();
		new StartUI().init(input, tracker);
	}
}
