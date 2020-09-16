package ru.job4j.tracker;

public class ShowAllAction extends PrintResult implements UserAction {
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
}