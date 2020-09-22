package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TrackerLazyStaticFieldTest {
	@Test
	public void whenInstanceTrackerLazyStaticField() {
		TrackerLazyStaticField tracker = TrackerLazyStaticField.getInstance();
		TrackerLazyStaticField trackerTwo = TrackerLazyStaticField.getInstance();
		assertThat(tracker, is(trackerTwo));
	}

}