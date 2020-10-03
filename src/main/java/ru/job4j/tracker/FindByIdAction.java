package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
	private final Output out;

	public FindByIdAction(Output out) {
		this.out = out;
	}

	@Override
	public String name() {
		return "Find item by Id";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		int id = input.askInt("--- Input id of item ---");
		Item rsl = tracker.findById(id);
		if (rsl == null) {
			out.println("Заявка с таким id не найдена");
		} else {
			printResult(rsl);
		}
		return true;
	}


	private void printResult(Item item) {
		out.println(item.getId() + " - " + item.getName());
	}
}