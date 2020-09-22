package ru.job4j.tracker;

public enum TrackerEnum {
	INSTANCE;

	private Tracker tracker = new Tracker();

	public Tracker getTracker() {
		return tracker;
	}
}
