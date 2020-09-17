package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
	@Override
	public String name() {
		return "Show all items";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		Item[] items = tracker.findAll();
		if (items.length == 0) {
			System.out.println("null");
		} else {
			for (Item item: items) {
				printResult(item);
			}
		}
		return true;
	}

	public static void printResult(Item item) {
		System.out.println(item.getId() + " - " + item.getName());
	}
}