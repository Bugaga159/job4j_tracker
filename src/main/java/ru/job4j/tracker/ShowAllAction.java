package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
	private final Output out;

	public ShowAllAction(Output out) {
		this.out = out;
	}

	@Override
	public String name() {
		return "Show all items";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		List<Item> items = tracker.findAll();
		if (items.size() == 0) {
			out.println("null");
		} else {
			for (Item item: items) {
				printResult(item);
			}
		}
		return true;
	}

	private void printResult(Item item) {
		out.println(item.getId() + " - " + item.getName());
	}
}