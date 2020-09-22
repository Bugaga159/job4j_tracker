package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TrackerLazyStaticPrivateFinalFieldTest {
	@Test
	public void whenInstanceTrackerLazyStaticPrivateFinalField() {
		TrackerLazyStaticPrivateFinalField tracker = TrackerLazyStaticPrivateFinalField.getInstance();
		TrackerLazyStaticPrivateFinalField trackerTwo = TrackerLazyStaticPrivateFinalField.getInstance();
		assertThat(tracker, is(trackerTwo));
	}

}