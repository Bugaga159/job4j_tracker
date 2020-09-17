package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
	private final Output out;

	public ReplaceAction(Output out) {
		this.out = out;
	}

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

	private void printResult(boolean rst, int id) {
		out.println(rst
				? "--- SUCCESS ---"
				: "--- FAIL: id:" + id + " does not exist ---");
	}
}