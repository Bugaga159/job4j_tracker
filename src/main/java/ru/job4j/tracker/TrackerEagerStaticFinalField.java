package ru.job4j.tracker;

public class TrackerEagerStaticFinalField {
	private static final TrackerEagerStaticFinalField INSTANCE = new TrackerEagerStaticFinalField();
	private Tracker tracker = new Tracker();

	private TrackerEagerStaticFinalField() {
	}

	public static TrackerEagerStaticFinalField getInstance() {
		return INSTANCE;
	}

	public Tracker getTracker() {
		return tracker;
	}
}
