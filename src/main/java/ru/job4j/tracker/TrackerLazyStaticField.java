package ru.job4j.tracker;

public class TrackerLazyStaticField {
	private static TrackerLazyStaticField instance;
	private Tracker tracker = new Tracker();

	private TrackerLazyStaticField() {
	}

	public static TrackerLazyStaticField getInstance() {
		if (instance == null) {
			instance = new TrackerLazyStaticField();
		}
		return instance;
	}

	public Tracker getTracker() {
		return tracker;
	}
}
