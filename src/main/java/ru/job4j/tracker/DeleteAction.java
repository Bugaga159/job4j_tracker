package ru.job4j.tracker;

public class DeleteAction implements UserAction {
	@Override
	public String name() {
		return "Delete item";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		int id = input.askInt("--- Input id of item ---");
		boolean rsl = tracker.delete(id);
		printResult(rsl, id);
		return true;
	}

	private static void printResult(boolean rst, int id) {
		System.out.println(rst
				? "--- SUCCESS ---"
				: "--- FAIL: id:" + id + " does not exist ---");
	}
}