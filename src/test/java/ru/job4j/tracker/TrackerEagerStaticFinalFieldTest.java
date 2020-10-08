package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TrackerEagerStaticFinalFieldTest {
	@Test
	public void whenInstanceTrackerEagerStaticFinalField() {
		TrackerEagerStaticFinalField tracker = TrackerEagerStaticFinalField.getInstance();
		TrackerEagerStaticFinalField trackerTwo = TrackerEagerStaticFinalField
				.getInstance();
		assertThat(tracker, is(trackerTwo));
	}

}