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
}