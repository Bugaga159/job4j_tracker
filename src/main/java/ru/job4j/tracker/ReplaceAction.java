package ru.job4j.tracker;

public class ReplaceAction extends PrintResult implements UserAction {
	@Override
	public String name() {
		return "Edit item";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		int id = input.askInt("Enter id:");
		String name = input.askStr("Enter a new name of item: ");
		Item item = new Item(name);
		item.setId(id);
		boolean rsl = tracker.replace(id, item);
		printResult(rsl, id);
		return true;
	}
}