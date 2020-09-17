package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
	private final Output out;

	public FindByNameAction(Output out) {
		this.out = out;
	}

	@Override
	public String name() {
		return "Find items by name";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		String name = input.askStr("--- Input the name of items ---");
		Item[] items = tracker.findByName(name);
		if (items.length == 0) {
			out.println("Заявки с таким именем не найдены");
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