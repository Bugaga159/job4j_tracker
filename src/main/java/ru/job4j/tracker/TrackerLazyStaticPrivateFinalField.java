package ru.job4j.tracker;

public class TrackerLazyStaticPrivateFinalField {
	private static TrackerLazyStaticPrivateFinalField instance;
	private Tracker tracker = new Tracker();

	private TrackerLazyStaticPrivateFinalField() {
	}

	public static TrackerLazyStaticPrivateFinalField getInstance() {
		return Holder.INSTANCE;
	}

	private static final class Holder {
		private static final TrackerLazyStaticPrivateFinalField INSTANCE;

		static {
			INSTANCE = new TrackerLazyStaticPrivateFinalField();
		}
	}

	public Tracker getTracker() {
		return tracker;
	}
}
