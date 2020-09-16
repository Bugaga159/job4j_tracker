package ru.job4j.tracker;

public class ExitAppAction extends PrintResult implements UserAction {
	@Override
	public String name() {
		return "Exit Program";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		System.out.println("--- Goodbye!---");
		return false;
	}
}