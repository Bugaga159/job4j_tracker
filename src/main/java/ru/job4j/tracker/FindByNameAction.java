package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
	@Override
	public String name() {
		return "Find items by name";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		String name = input.askStr("--- Input the name of items ---");
		Item[] items = tracker.findByName(name);
		if (items.length == 0) {
			System.out.println("Заявки с таким именем не найдены");
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