package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TrackerEnumTest {
	@Test
	public void whenInstanceEnumTracker() {
		TrackerEnum tracker = TrackerEnum.INSTANCE;
		TrackerEnum trackerTwo = TrackerEnum.INSTANCE;
		assertThat(tracker, is(trackerTwo));
	}

	@Test
	public void whenInstanceTrackerEagerStaticFinalField() {
		TrackerEagerStaticFinalField tracker = TrackerEagerStaticFinalField.getInstance();
		TrackerEagerStaticFinalField trackerTwo = TrackerEagerStaticFinalField.getInstance();
		assertThat(tracker, is(trackerTwo));
	}

	@Test
	public void whenInstanceTrackerLazyStaticField() {
		TrackerLazyStaticField tracker = TrackerLazyStaticField.getInstance();
		TrackerLazyStaticField trackerTwo = TrackerLazyStaticField.getInstance();
		assertThat(tracker, is(trackerTwo));
	}

	@Test
	public void whenInstanceTrackerLazyStaticPrivateFinalField() {
		TrackerLazyStaticPrivateFinalField tracker = TrackerLazyStaticPrivateFinalField.getInstance();
		TrackerLazyStaticPrivateFinalField trackerTwo = TrackerLazyStaticPrivateFinalField.getInstance();
		assertThat(tracker, is(trackerTwo));
	}
}