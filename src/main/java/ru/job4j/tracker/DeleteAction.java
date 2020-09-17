package ru.job4j.tracker;

public class DeleteAction implements UserAction {
	private final Output out;

	public DeleteAction(Output out) {
		this.out = out;
	}

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

	private void printResult(boolean rst, int id) {
		out.println(rst
				? "--- SUCCESS ---"
				: "--- FAIL: id:" + id + " does not exist ---");
	}
}