package ru.job4j.tracker;

public class ExitAppAction implements UserAction {
	private final Output out;

	public ExitAppAction(Output out) {
		this.out = out;
	}

	@Override
	public String name() {
		return "Exit Program";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		out.println("--- Goodbye!---");
		return false;
	}
}