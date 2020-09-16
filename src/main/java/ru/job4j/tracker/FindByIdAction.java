package ru.job4j.tracker;

public class FindByIdAction extends PrintResult implements UserAction {
	@Override
	public String name() {
		return "Find item by Id";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		int id = input.askInt("--- Input id of item ---");
		Item rsl = tracker.findById(id);
		if (rsl == null) {
			System.out.println("Заявка с таким id не найдена");
		} else {
			printResult(rsl);
		}
		return true;
	}
}